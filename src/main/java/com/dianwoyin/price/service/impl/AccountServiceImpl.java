package com.dianwoyin.price.service.impl;

import com.alibaba.fastjson.JSON;
import com.dianwoyin.price.BusinessException;
import com.dianwoyin.price.service.AccountService;
import com.dianwoyin.price.service.QcloudFileService;
import com.dianwoyin.price.service.RedisService;
import com.dianwoyin.price.constants.RedisCacheKey;
import com.dianwoyin.price.constants.enums.AccountStatusEnum;
import com.dianwoyin.price.constants.enums.ErrorCodeEnum;
import com.dianwoyin.price.dto.UserLogin;
import com.dianwoyin.price.dto.WxLoginResponseDTO;
import com.dianwoyin.price.entity.Account;
import com.dianwoyin.price.helper.AccountLoginHelper;
import com.dianwoyin.price.mapper.AccountMapper;
import com.dianwoyin.price.utils.EncryptUtils;
import com.dianwoyin.price.utils.HttpClientUtils;
import com.dianwoyin.price.utils.PriceBeanUtils;
import com.dianwoyin.price.vo.request.AccountUpdateRequest;
import com.dianwoyin.price.vo.response.acount.AccountResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.Objects;

import static com.dianwoyin.price.constants.enums.ErrorCodeEnum.*;

/**
 * @author chunxu.dong
 * @date 2020/12/14
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    private static final String wx_url = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";
    private static final String WX_STATUS_OK = "0";
    @Autowired
    private RedisService redisService;
    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private QcloudFileService qcloudFileService;


    @Override
    public Boolean loginByWxUnion(String wxCode) {
        try {
            WxLoginResponseDTO wxLoginResponseDTO = JSON.parseObject(HttpClientUtils.doGet(wx_url), WxLoginResponseDTO.class);

            if (wxLoginResponseDTO == null || !Objects.equals(wxLoginResponseDTO.getErrCode(), WX_STATUS_OK)) {
                throw new BusinessException(ErrorCodeEnum.UNION_LOGIN_WX_FAILED);
            }

            // 查询open id 是否已经存在
            Account account = accountMapper.selectByOpenId(wxLoginResponseDTO.getOpenId());
            if (account == null) {
                account = quickRegister(wxLoginResponseDTO.getOpenId());
            }

            AccountResponse accountRespBO = PriceBeanUtils.copyProperty(account, AccountResponse.class);

            return true;
        } catch (Exception e) {
            throw new BusinessException(ErrorCodeEnum.UNION_LOGIN_WX_FAILED);
        }
    }

    private Account quickRegister(String openId) {
        return Account.builder()
                .build();
    }

    @Override
    public Boolean loginByPhone(String phone, String smsCode) {
        if (StringUtils.isEmpty(phone) || StringUtils.isEmpty(smsCode)) {
            throw new BusinessException(ERROR_COMMON_PARAM);
        }

        String loginSmsCode = AccountLoginHelper.getLoginSmsCode();
        if (!smsCode.equals(loginSmsCode)) {
            throw new BusinessException(ERROR_SMS_CODE);
        }

        Account account = accountMapper.selectByPhone(phone);
        if (account == null) {
            throw new BusinessException(USER_NOT_EXIST);
        }
        // 快速登录
        quickLogin(account);
        return true;
    }

    @Override
    public Boolean loginByPassword(String username, String password) {
        String encryptPass = EncryptUtils.md5(password);
        Account account = accountMapper.selectByUsernameAndPassword(username, encryptPass);
        if (account == null) {
            throw new BusinessException(USER_NOT_EXIST);
        }

        // 生成token
        String token = EncryptUtils.md5(account.getUsername());

        // 生成缓存
        redisService.setObject(String.format(RedisCacheKey.USER_LOGIN, account.getId()), token);

        return true;
    }

    @Override
    public Boolean logout() {
        try {
            AccountLoginHelper.logout();
        } catch (Exception e) {
            throw new BusinessException(SESSION_OUT);
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateAccount(AccountUpdateRequest accountUpdateRequest) {
        Account updateAccount = PriceBeanUtils.copyProperty(accountUpdateRequest, Account.class);
        accountMapper.updateByPrimaryKeySelective(updateAccount);
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean registerByPhone(String phone, String smsCode) {
        String loginSmsCode = AccountLoginHelper.getLoginSmsCode();
        if (!smsCode.equals(loginSmsCode)) {
            throw new BusinessException(ERROR_SMS_CODE);
        }

        Date now = new Date();
        String loginIp = AccountLoginHelper.getLoginIp();

        Account newAccount = Account.builder()
                .username("")
                .password(EncryptUtils.md5(smsCode))
                .phone(phone)
                .status(AccountStatusEnum.NoReview.getCode())
                .firstName("")
                .lastName("")
                .sex(0)
                .lastLoginIp(loginIp)
                .lastLoginTime(now)
                .inviteCode("")
                .openId("")
                .createTime(now)
                .updateTime(now)
                .deleted(false)
                .build();

        accountMapper.insert(newAccount);

        quickLogin(newAccount);
        return true;
    }

    @Override
    public AccountResponse getAccountByPhone(String phone) {
        Account account = accountMapper.selectByPhone(phone);
        if (account == null) {
            throw new BusinessException(USER_NOT_EXIST);
        }
        return PriceBeanUtils.copyProperty(account, AccountResponse.class);
    }

    @Override
    public Boolean getLoginSmsCode(String phone) {
        AccountLoginHelper.sendLoginSmsCode();
        return true;
    }

    @Override
    public String uploadAvatar(MultipartFile file) {
        try {
            return qcloudFileService.uploadImg(file);
        } catch (IOException e) {
            log.error("uploadAvatar error", e);
            throw new BusinessException(ERROR_COMMON_IMG_UPLOAD);
        }
    }

    private void quickLogin(Account newAccount) {
        AccountLoginHelper.setLogin(PriceBeanUtils.copyProperty(newAccount, UserLogin.class));
    }
}

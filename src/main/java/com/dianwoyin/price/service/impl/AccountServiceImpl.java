package com.dianwoyin.price.service.impl;

import com.alibaba.fastjson.JSON;
import com.dianwoyin.price.BusinessException;
import com.dianwoyin.price.respository.AccountRepository;
import com.dianwoyin.price.service.AccountService;
import com.dianwoyin.price.service.QcloudFileService;
import com.dianwoyin.price.service.RedisService;
import com.dianwoyin.price.constants.RedisCacheKey;
import com.dianwoyin.price.constants.enums.AccountStatusEnum;
import com.dianwoyin.price.constants.enums.ErrorCodeEnum;
import com.dianwoyin.price.dto.UserLogin;
import com.dianwoyin.price.dto.WxLoginResponseDTO;
import com.dianwoyin.price.model.Account;
import com.dianwoyin.price.helper.AccountLoginHelper;
import com.dianwoyin.price.utils.EncryptUtils;
import com.dianwoyin.price.utils.HttpClientUtils;
import com.dianwoyin.price.utils.JwtUtils;
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
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.dianwoyin.price.constants.enums.ErrorCodeEnum.*;

/**
 * @author chunxu.dong
 * @date 2020/12/14
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    private static final String WX_URL = "https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code";
    private static final String APP_ID = "wxabad98c4064cbd7b";
    private static final String SECRET = "fff605584d763a93db3ee6343f0df8b8";

    @Autowired
    private RedisService redisService;

    @Autowired
    private QcloudFileService qcloudFileService;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private JwtUtils jwtUtils;


    @Override
    public Boolean loginByWxUnion(String wxCode) {
        try {

            WxLoginResponseDTO wxLoginResponseDTO = JSON.parseObject(HttpClientUtils.doGet(
                    String.format(WX_URL, APP_ID, SECRET, wxCode)), WxLoginResponseDTO.class);

            if (wxLoginResponseDTO == null || !Objects.equals(wxLoginResponseDTO.getErrCode(), 0)) {
                throw new BusinessException(ErrorCodeEnum.UNION_LOGIN_WX_FAILED);
            }
            // 查询open id 是否已经存在
            Account account = accountRepository.queryAccountByOpenId(wxLoginResponseDTO.getOpenId());
            if (account == null) {
                quickRegisterByWxOpenId(wxLoginResponseDTO.getOpenId());
            }

            return true;
        } catch (Exception e) {
            throw new BusinessException(ErrorCodeEnum.UNION_LOGIN_WX_FAILED);
        }
    }

    private void quickRegisterByWxOpenId(String openId) {
        Account account = Account.builder()
                .openId(openId)
                .lastLoginTime(LocalDateTime.now())
                .deleted(false)
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();
        accountRepository.addAccount(account);
    }

    @Override
    public String loginByPhone(String phone, String smsCode) {
        if (StringUtils.isEmpty(phone) || StringUtils.isEmpty(smsCode)) {
            throw new BusinessException(ERROR_COMMON_PARAM);
        }

        String loginSmsCode = AccountLoginHelper.getLoginSmsCode();
        if (!smsCode.equals(loginSmsCode)) {
            throw new BusinessException(ERROR_SMS_CODE);
        }

        Account account = accountRepository.queryAccountByPhone(phone);
        if (account == null) {
            throw new BusinessException(USER_NOT_EXIST);
        }

        Map<String, Object> body = new HashMap<>();
        body.put("userName", account.getUsername());
        body.put("firstName", account.getFirstName());
        body.put("lastName", account.getLastName());
        return jwtUtils.createJwt(account.getId()+"", account.getPhone(), body);
    }

    @Override
    public Boolean loginByPassword(String username, String password) {
        String encryptPass = EncryptUtils.md5(password);
        Account account = accountRepository.queryAccountByUsernameAndPassword(username, encryptPass);
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
        accountRepository.updateAccount(updateAccount);
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean registerByPhone(String phone, String smsCode) {
        String loginSmsCode = AccountLoginHelper.getLoginSmsCode();
        if (!smsCode.equals(loginSmsCode)) {
            throw new BusinessException(ERROR_SMS_CODE);
        }

        String loginIp = AccountLoginHelper.getLoginIp();

        Account newAccount = Account.builder()
                .username("")
                .password(EncryptUtils.md5(smsCode))
                .phone(phone)
                .status(AccountStatusEnum.NoReview.getCode())
                .firstName("")
                .lastName("")
                .sex(true)
                .lastLoginIp(loginIp)
                .lastLoginTime(LocalDateTime.now())
                .inviteCode("")
                .openId("")
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .deleted(false)
                .build();

        accountRepository.addAccount(newAccount);
        quickLogin(newAccount);
        return true;
    }

    @Override
    public AccountResponse getAccountByPhone(String phone) {
        Account account = accountRepository.queryAccountByPhone(phone);
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
            String fileName = file.getOriginalFilename();
            if (StringUtils.isEmpty(fileName)) {
                throw new BusinessException(ERROR_COMMON_PARAM);
            }

            int i = fileName.lastIndexOf(".");
            String extension = fileName.substring(i+1);
            if (!extension.equals("png") && !extension.equals("jpg")
                    && !extension.equals("jpeg")) {
                throw new BusinessException(ERROR_COMMON_PARAM.getCode(), "请上传正确的图片格式(jpeg, jpg, png)");
            }

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

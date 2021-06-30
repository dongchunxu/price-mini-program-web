package com.dianwoyin.price.service;

import com.dianwoyin.price.vo.request.AccountUpdateRequest;
import com.dianwoyin.price.vo.response.acount.AccountResponse;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author chunxu.dong
 * @date 2020/12/14
 */
public interface AccountService {

    Boolean loginByWxUnion(String wxCode);

    String loginByPhone(String phone, String smsCode);

    Boolean loginByPassword(String username, String password);

    Boolean logout();

    Boolean updateAccount(AccountUpdateRequest accountUpdateRequest);

    Boolean registerByPhone(String phone, String smsCode);

    AccountResponse getAccountByPhone(String phone);

    Boolean getLoginSmsCode(String phone);

    String uploadAvatar(MultipartFile file);
}

package com.dianwoyin.price.api;

import com.dianwoyin.price.vo.response.AccountResponse;
import com.dianwoyin.price.vo.request.AccountUpdateRequest;

/**
 * @author chunxu.dong
 * @date 2020/12/14
 */
public interface AccountService {

    Boolean loginByWxUnion(String wxCode);

    Boolean loginByPhone(String phone, String smsCode);

    Boolean loginByPassword(String username, String password);

    Boolean logout();

    Boolean updateAccount(AccountUpdateRequest accountUpdateRequest);

    Boolean registerByPhone(String phone, String smsCode);

    AccountResponse getAccountByPhone(String phone);

    Boolean getLoginSmsCode(String phone);
}

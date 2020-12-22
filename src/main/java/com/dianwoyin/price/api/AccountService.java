package com.dianwoyin.price.api;

import com.dianwoyin.price.vo.response.AccountResponseVO;
import com.dianwoyin.price.vo.request.AccountUpdateRequestVO;

/**
 * @author chunxu.dong
 * @date 2020/12/14
 */
public interface AccountService {

    Boolean loginUnionByWx(String wxCode);

    Boolean loginByPhone(String phone, String smsCode);

    Boolean loginByPassword(String username, String password);

    Boolean logout();

    Boolean updateAccount(AccountUpdateRequestVO accountUpdateRequestVO);

    Boolean registerByPhone(String phone, String smsCode);

    AccountResponseVO getAccountByPhone(String phone);

    Boolean getLoginSmsCode(String phone);
}

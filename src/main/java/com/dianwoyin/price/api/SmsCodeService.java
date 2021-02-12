package com.dianwoyin.price.api;

/**
 * @author chunxu.dong
 * @date 2020/12/14
 */
public interface SmsCodeService {
    void sendLoginVerifySmsCode(String phone);
}

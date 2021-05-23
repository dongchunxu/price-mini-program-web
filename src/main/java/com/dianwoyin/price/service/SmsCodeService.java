package com.dianwoyin.price.service;

/**
 * @author chunxu.dong
 * @date 2020/12/14
 */
public interface SmsCodeService {
    void sendLoginVerifySmsCode(String phone);
}

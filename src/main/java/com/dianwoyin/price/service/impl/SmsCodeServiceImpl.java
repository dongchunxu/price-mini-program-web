package com.dianwoyin.price.service.impl;

import com.dianwoyin.price.service.RedisService;
import com.dianwoyin.price.service.SmsCodeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chunxu.dong
 * @date 2020/12/14
 */
@Service
@Slf4j
public class SmsCodeServiceImpl implements SmsCodeService {

    @Autowired
    private RedisService redisService;

    @Override
    public void sendLoginVerifySmsCode(String phone) {
        String fake = "1234";
//        redisService.set(String.format(RedisCacheKey.SMS_CODE, phone), fake);
    }
}

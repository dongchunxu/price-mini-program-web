package com.dianwoyin.price.service;

import com.dianwoyin.price.api.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author chunxu.dong
 * @date 2020/12/14
 */
@Service
@Slf4j
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void set(String key, Object objVal) {
        // 默认超时半小时
        redisTemplate.boundValueOps(key).set(objVal, 100000);
    }

    @Override
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    @Override
    public String getStringValue(String key) {
        return (String) redisTemplate.boundValueOps(key).get();
    }

    @Override
    public <T> T getObject(String key, Class<T> clazz) {
        return (T) redisTemplate.boundValueOps(key).get();
    }

    @Override
    public Boolean keyExists(String key) {
        return redisTemplate.hasKey(key);
    }
}

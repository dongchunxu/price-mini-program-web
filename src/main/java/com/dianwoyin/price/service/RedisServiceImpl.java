package com.dianwoyin.price.service;

import com.dianwoyin.price.api.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author chunxu.dong
 * @date 2020/12/14
 */
@Service
@Slf4j
public class RedisServiceImpl implements RedisService {

    @Resource(name = "objRedisTemplate")
    private RedisTemplate redisTemplate;


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
        return (T) redisTemplate.opsForValue().get(key);
    }

    @Override
    public void setObject(String key, Object objVal) {
        // 默认超时半小时
        redisTemplate.opsForValue().set(key, objVal);
    }

    @Override
    public Boolean keyExists(String key) {
        return redisTemplate.hasKey(key);
    }
}

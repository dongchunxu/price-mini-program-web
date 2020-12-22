package com.dianwoyin.price.api;

/**
 * @author chunxu.dong
 * @date 2020/12/14
 */
public interface RedisService {

    void set(String key, Object objVal);

    void delete(String key);

    String getStringValue(String key);

    <T> T getObject(String key, Class<T> clazz);

    Boolean keyExists(String key);
}

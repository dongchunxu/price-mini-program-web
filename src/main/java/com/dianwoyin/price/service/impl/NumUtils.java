package com.dianwoyin.price.service.impl;

import org.springframework.data.redis.connection.ClusterSlotHashUtil;

import java.util.Random;
import java.util.UUID;

/**
 * @author chunxu.dong
 * @date 2021/7/1
 */
public class NumUtils {

    public static String randomNum(String prefix, int len) {
        return UUID.randomUUID().toString().substring(0, len);
    }
}

package com.dianwoyin.price.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {

//    @Primary
    @Bean
    public StringRedisTemplate userRedisTemplate(
            @Value("${spring.redis.host}") String hostName,
            @Value("${spring.redis.password}") String password,
            @Value("${spring.redis.port}") int port,
            @Value("${spring.redis.jedis.pool.max-idle}") int maxIdle,
            @Value("${spring.redis.jedis.pool.min-idle}") int minIdle,
            @Value("${spring.redis.jedis.pool.max-active}") int maxTotal,
            @Value("${spring.redis.lettuce.pool.max-wait}") long maxWaitMillis) {
        StringRedisTemplate temple = new StringRedisTemplate();
        temple.setConnectionFactory(connectionFactory(hostName, password,
               port, maxIdle, minIdle, maxTotal, maxWaitMillis));

        return temple;
    }

//    @Bean
//    public StringRedisTemplate shopRedisTemplate(
//            @Value("${spring.redis.single.host}") String hostName,
//            @Value("${spring.redis.single.password}") String password,
//            @Value("${spring.redis.single.port}") int port,
//            @Value("${spring.redis.single.maxIdle}") int maxIdle,
//            @Value("${spring.redis.single.minIdle}") int minIdle,
//            @Value("${spring.redis.single.maxActive}") int maxTotal,
//            @Value("${spring.redis.single.maxWaitMillis}") long maxWaitMillis) {
//        StringRedisTemplate temple = new StringRedisTemplate();
//        temple.setConnectionFactory(connectionFactory(hostName, password, port, maxIdle, minIdle, maxTotal, maxWaitMillis));
//
//        return temple;
//    }

//    @Bean
//    public JedisPool storeRedisPool(
//            @Value("${spring.redis.single.host}") String hostName,
//            @Value("${spring.redis.single.port}") int port,
//            @Value("${spring.redis.single.maxIdle}") int maxIdle,
//            @Value("${spring.redis.single.minIdle}") int minIdle,
//            @Value("${spring.redis.single.maxActive}") int maxTotal,
//            @Value("${spring.redis.single.maxWaitMillis}") long maxWaitMillis) {
//        JedisPoolConfig jedisPoolConfig = poolCofig(maxIdle, minIdle, maxTotal, maxWaitMillis);
//        JedisPool jedisPool = new JedisPool(jedisPoolConfig, hostName, port, 3000);
//        return jedisPool;
//    }


    private RedisConnectionFactory connectionFactory(String hostName,
                                                     String password,
                                                     int port,
                                                     int maxIdle,
                                                     int minIdle, int maxTotal, long maxWaitMillis) {

        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName(hostName);
        redisStandaloneConfiguration.setPassword(RedisPassword.of(password));
        redisStandaloneConfiguration.setPort(port);
        //获得默认的连接池构造器
        JedisClientConfiguration.JedisPoolingClientConfigurationBuilder jpcb =
                (JedisClientConfiguration.JedisPoolingClientConfigurationBuilder) JedisClientConfiguration.builder();
        //指定jedisPoolConifig来修改默认的连接池构造器
        jpcb.poolConfig(poolCofig(maxIdle, minIdle, maxTotal, maxWaitMillis));
        //通过构造器来构造jedis客户端配置
        JedisClientConfiguration jedisClientConfiguration = jpcb.build();
        //单机配置 + 客户端配置 = jedis连接工厂
        return new JedisConnectionFactory(redisStandaloneConfiguration, jedisClientConfiguration);
    }

    private JedisPoolConfig poolCofig(int maxIdle, int minIdle, int maxTotal, long maxWaitMillis) {

        JedisPoolConfig poolCofig = new JedisPoolConfig();
        poolCofig.setMaxIdle(maxIdle);
        poolCofig.setMinIdle(minIdle);
        poolCofig.setMaxTotal(maxTotal);
        poolCofig.setMaxWaitMillis(maxWaitMillis);

        return poolCofig;
    }

}


package com.dianwoyin.price.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
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

    @Bean
    public <K, V> RedisTemplate<K, V> objRedisTemplate(
            @Value("${spring.redis.host}") String hostName,
            @Value("${spring.redis.password}") String password,
            @Value("${spring.redis.port}") int port,
            @Value("${spring.redis.jedis.pool.max-idle}") int maxIdle,
            @Value("${spring.redis.jedis.pool.min-idle}") int minIdle,
            @Value("${spring.redis.jedis.pool.max-active}") int maxTotal,
            @Value("${spring.redis.lettuce.pool.max-wait}") long maxWaitMillis) {
        RedisTemplate<K, V> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(connectionFactory(hostName, password,
                port, maxIdle, minIdle, maxTotal, maxWaitMillis));

        // 使用Jackson2JsonRedisSerialize 替换默认序列化
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);

        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);

        // 设置value的序列化规则和 key的序列化规则
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;

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


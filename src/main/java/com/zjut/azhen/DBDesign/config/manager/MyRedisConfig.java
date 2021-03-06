package com.zjut.azhen.DBDesign.config.manager;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.*;
import org.springframework.data.redis.cache.*;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * author:zj
 * Date:2020/4/3
 * Time:16:06
 */
@Configuration
@EnableCaching
public class MyRedisConfig extends CachingConfigurerSupport {

    @Bean
    public org.springframework.data.redis.core.RedisTemplate<Object, Object> redisTemplate(org.springframework.data.redis.connection.RedisConnectionFactory redisConnectionFactory) {
        org.springframework.data.redis.core.RedisTemplate<Object, Object> redisTemplate = new org.springframework.data.redis.core.RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        //使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value值（默认使用JDK的序列化方式）
        org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer<Object> serializer = new org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer<>(Object.class);

        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        serializer.setObjectMapper(mapper);

        redisTemplate.setValueSerializer(serializer);

        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }


    @Bean
    @Override
    public KeyGenerator keyGenerator() {
        return (o, method, objects) -> {
            StringBuilder sb = new StringBuilder();
            sb.append(o.getClass().getName()).append(".");
            sb.append(method.getName()).append(".");
            for (Object obj : objects) {
                sb.append(obj.toString());
            }
            System.out.println("keyGenerator=" + sb.toString());
            return sb.toString();
        };
    }


    @Bean
    public CacheManager cacheManager(org.springframework.data.redis.connection.RedisConnectionFactory connectionFactory) {
        RedisCacheWriter redisCacheWriter =RedisCacheWriter.lockingRedisCacheWriter(connectionFactory);
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();
        return new MyRedisCacheManager(redisCacheWriter,redisCacheConfiguration);

    }




}


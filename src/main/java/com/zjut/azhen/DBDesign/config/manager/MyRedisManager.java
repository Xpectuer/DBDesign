package com.zjut.azhen.DBDesign.config.manager;


import org.springframework.data.redis.cache.*;

/**
 * author:zj
 * Date:2020/4/8
 * Time:15:01
 */
class MyRedisCacheManager extends RedisCacheManager {
    private final RedisCacheWriter cacheWriter;
    private final RedisCacheConfiguration defaultCacheConfig;

    /** 用于返回自定义的redisCache **/
    @Override
    protected RedisCache createRedisCache(String name, RedisCacheConfiguration cacheConfig) {
        return new CustomizedRedisCache(name, cacheWriter, cacheConfig != null ? cacheConfig : defaultCacheConfig);

    }

    public MyRedisCacheManager(RedisCacheWriter cacheWriter, RedisCacheConfiguration defaultCacheConfiguration) {
        super(cacheWriter, defaultCacheConfiguration);
        this.cacheWriter = cacheWriter;
        this.defaultCacheConfig = defaultCacheConfiguration;
    }

}


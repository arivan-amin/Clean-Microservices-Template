package com.arivanamin.healthcare.backend.api.gateway.infrastructure.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.util.concurrent.TimeUnit.MINUTES;

@Configuration
public class CacheConfig {
    
    public static final int CACHE_EXPIRY_DURATION = 30;
    public static final int CACHE_MAXIMUM_SIZE = 500;
    
    @Bean
    public CacheManager cacheManager () {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        cacheManager.setCaffeine(caffeineCacheBuilder());
        return cacheManager;
    }
    
    @Bean
    public Caffeine<Object, Object> caffeineCacheBuilder () {
        return Caffeine.newBuilder()
            .initialCapacity(100)
            .maximumSize(CACHE_MAXIMUM_SIZE)
            .expireAfterWrite(CACHE_EXPIRY_DURATION, MINUTES)
            .recordStats();
    }
}

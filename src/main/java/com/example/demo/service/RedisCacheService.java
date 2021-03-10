package com.example.demo.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class RedisCacheService {

    @Cacheable(cacheNames = "UserCache")
    public String longRunnigMethod() throws InterruptedException {
        Thread.sleep(3000L);
        return "method calisti";
    }

    @CacheEvict(cacheNames = "UserCache")
    public void clearCache(){
        System.out.println("cache temizledi");
    }
}

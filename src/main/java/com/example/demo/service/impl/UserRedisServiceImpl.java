package com.example.demo.service.impl;

import com.example.demo.model.UserRedis;
import com.example.demo.model.entity.UserEntity;
import com.example.demo.repository.UserRedisRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRedisServiceImpl implements UserRedisService {

    @Autowired
    UserRedisRepository userRedisRepository;


    @Override
    @Cacheable(cacheNames = "UserCache")
    public void save(UserRedis userRedis) {
        userRedisRepository.save(userRedis);
    }

    @Override
    @Cacheable(cacheNames = "UserCache")
    public UserRedis getUser(String username) {
        UserRedis userRedis= userRedisRepository.findById(username).get();
        return userRedis;
    }

    @Override
    @Cacheable(cacheNames = "UserCache")
    public List<UserRedis> userList() {
        List<UserRedis> users = new ArrayList<>();
        userRedisRepository.findAll().forEach(users::add);
        return users;
    }
}

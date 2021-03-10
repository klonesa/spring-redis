package com.example.demo.service;

import com.example.demo.model.UserRedis;
import com.example.demo.model.entity.UserEntity;

import java.util.List;

public interface UserRedisService {
    void save(UserRedis userRedis);
    UserRedis getUser(String username);
    List<UserRedis> userList();
}

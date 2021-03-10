package com.example.demo.service;

import com.example.demo.model.entity.UserEntity;

public interface UserService {
    UserEntity getUser(String username);
}

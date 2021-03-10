package com.example.demo.service.impl;

import com.example.demo.model.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserEntity getUser(String username) {
        UserEntity user = userRepository.findByUserName(username);
        return user;
    }
}

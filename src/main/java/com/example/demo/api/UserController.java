package com.example.demo.api;

import com.example.demo.model.UserRedis;
import com.example.demo.model.entity.UserEntity;
import com.example.demo.service.RedisCacheService;
import com.example.demo.service.UserRedisService;
import com.example.demo.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRedisService userRedisService;

    @Autowired
    private RedisCacheService redisCacheService;


    @GetMapping()
    public ResponseEntity<UserEntity> getUser(){
        UserEntity getUser = userService.getUser("Sercan");
        return ResponseEntity.ok(getUser);
    }

    @PostMapping("/redis")
    public void createUser(@RequestBody UserRedis post) {
        userRedisService.save(post);
    }

    @GetMapping("/userRedis")
    public ResponseEntity<UserRedis> getRedisUser(){
        UserRedis getRedisUser = userRedisService.getUser("Sercan");
        return ResponseEntity.ok(getRedisUser);
    }
    @GetMapping("/userlist")
    public ResponseEntity<List<UserRedis>> getRedisUserList(){
        List<UserRedis> users = userRedisService.userList();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/test")
    public String cacheControl() throws InterruptedException {
        return redisCacheService.longRunnigMethod();
    }
    @GetMapping("/clear")
    public void clearCache() throws InterruptedException {
        redisCacheService.clearCache();
    }

}

package com.example.demo.model;

import lombok.*;
import org.springframework.data.redis.core.RedisHash;
import java.io.Serializable;

@RedisHash("user")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UserRedis implements Serializable {
    private String id;
    private String email;
}

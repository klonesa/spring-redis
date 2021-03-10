package com.example.demo.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name="email")
    private String email;

    @Column(name ="password")
    private String password;

    @Column(name="username")
    private String userName;
}

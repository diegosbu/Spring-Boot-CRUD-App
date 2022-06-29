package com.example.demo.service;

import com.example.demo.model.Users;

import java.util.List;

public interface UsersService {
    int insert(Users user);

    List<Users> findOne(Users user);

    boolean exists(Users user);
}

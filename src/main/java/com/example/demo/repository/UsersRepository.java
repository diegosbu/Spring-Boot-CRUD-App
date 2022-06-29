package com.example.demo.repository;

import com.example.demo.model.Users;

import java.util.List;

public interface UsersRepository {
    int insert(Users users);

    List<Users> findOne(Users user);

    boolean exists(Users user);
}

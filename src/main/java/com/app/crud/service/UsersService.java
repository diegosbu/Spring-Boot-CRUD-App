package com.app.crud.service;

import com.app.crud.model.Users;

import java.util.List;

public interface UsersService {
    int insert(Users user);

    List<Users> findOne(Users user);

    boolean exists(Users user);
}

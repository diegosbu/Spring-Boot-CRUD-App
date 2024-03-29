package com.app.crud.service;

import com.app.crud.model.users.Users;

import java.util.List;

public interface UsersService {
    int insert(Users user);

    List<Users> findOne(Users user);

    int findId();

    boolean exists(Users user);
}

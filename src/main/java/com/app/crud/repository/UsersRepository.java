package com.app.crud.repository;

import com.app.crud.model.Users;

import java.util.List;

public interface UsersRepository {
    int insert(Users users);

    List<Users> findOne(Users user);

    boolean exists(Users user);
}

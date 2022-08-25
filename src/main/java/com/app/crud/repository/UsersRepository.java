package com.app.crud.repository;

import com.app.crud.model.users.Users;

import java.util.List;

public interface UsersRepository {
    int insert(Users users);

    List<Users> findOne(Users user);

    //  findID - returns user_id based on email
    int findId(String email);

    boolean exists(Users user);
}

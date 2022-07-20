package com.app.crud.service;

import com.app.crud.model.Users;
import com.app.crud.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    UsersRepository usersRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    //  insert - calls usersRepository to insert non-existing user
    @Override
    public int insert(Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        if (exists(user)) {
            return 0;
        } else {
            return usersRepository.insert(user);
        }
    }

    //  findOne - calls usersRepository to return user info
    @Override
    public List<Users> findOne(Users user) {
        return usersRepository.findOne(user);
    }

    //  findOne - calls usersRepository to return if user exists
    @Override
    public boolean exists(Users user) {
        return usersRepository.exists(user);
    }

}

package com.example.demo.service;

import com.example.demo.model.Users;
import com.example.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    UsersRepository usersRepository;

    @Override
    public int insert(Users user) {
        if (exists(user)) {
            return 0;
        } else {
            return usersRepository.insert(user);
        }
    }

    @Override
    public List<Users> findOne(Users user) {
        return usersRepository.findOne(user);
    }

    @Override
    public boolean exists(Users user) {
        return usersRepository.exists(user);
    }

}

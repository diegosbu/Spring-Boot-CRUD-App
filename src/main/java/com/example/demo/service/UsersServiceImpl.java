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
        if (findOne(user).isEmpty()) {
            return usersRepository.insert(user);
        } else {
            return 0;
        }
    }

    @Override
    public List<Users> findOne(Users user) {
        return usersRepository.findOne(user);
    }

}

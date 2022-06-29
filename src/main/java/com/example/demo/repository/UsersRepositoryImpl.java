//code partially used from:
// https://www.javatpoint.com/RowMapper-example

package com.example.demo.repository;

import com.example.demo.model.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.model.Users;

import java.util.List;

@Repository
public class UsersRepositoryImpl implements UsersRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //    insert - Inserts potential new user into db
    @Override
    public int insert(Users formInput) {
        String userEmail = formInput.getEmail();
        String userPwd = formInput.getPassword();

        return jdbcTemplate.update("INSERT INTO users(email, password) VALUES(?, ?)", userEmail, userPwd);
    }

    //    findOne - Returns existing user info
    @Override
    public List<Users> findOne(Users formInput) {
        String userEmail = formInput.getEmail();
        String userPwd = formInput.getPassword();

        return jdbcTemplate.query("SELECT email from users WHERE email = ? AND password = ?", new UsersMapper(), userEmail, userPwd);
    }

    @Override
    public boolean exists(Users formInput) {
        String userEmail = formInput.getEmail();

        return !jdbcTemplate.query("SELECT email from users WHERE email = ?", new UsersMapper(), userEmail).isEmpty();
    }
}

//code partially used from: https://www.javatpoint.com/RowMapper-example

package com.app.crud.repository;

import com.app.crud.model.UsersEmailMapper;
import com.app.crud.model.UsersIdMapper;
import com.app.crud.model.UsersPwdMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.app.crud.model.Users;

import java.util.List;

@Repository
public class UsersRepositoryImpl implements UsersRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //  insert - inserts new user into db
    @Override
    public int insert(Users formInput) {
        String userEmail = formInput.getEmail();
        String userPwd = formInput.getPassword();

        return jdbcTemplate.update("INSERT INTO users(email, password) VALUES(?, ?)", userEmail, userPwd);
    }

    //  findOne - returns existing user info
    @Override
    public List<Users> findOne(Users formInput) {
        String userEmail = formInput.getEmail();

        return jdbcTemplate.query("SELECT email, password FROM users WHERE email = ?", new UsersPwdMapper(), userEmail);
    }

    //  findID - returns user id based on email
    @Override
    public int findId(String email) {
        List<Users> users = jdbcTemplate.query("SELECT user_id FROM users WHERE email = ?", new UsersIdMapper(),
                email);

        return users.get(0).getId();
    }

    //  exists - returns true if user exists
    @Override
    public boolean exists(Users formInput) {
        String userEmail = formInput.getEmail();

        return !jdbcTemplate.query("SELECT email FROM users WHERE email = ?", new UsersEmailMapper(), userEmail).isEmpty();
    }
}

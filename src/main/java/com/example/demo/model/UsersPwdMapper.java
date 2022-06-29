package com.example.demo.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersPwdMapper extends UsersMapper implements RowMapper {
    @Override
    public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
        Users user = super.mapRow(rs, rowNum);
        user.setPassword(rs.getString("password"));

        return user;
    }
}

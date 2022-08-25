package com.app.crud.model.users;

// code modelled off of: https://www.tutorialspoint.com/springjdbc/springjdbc_rowmapper.htm

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

// UsersPwdMapper - RowMapper tht maps email and password
public class UsersPwdMapper extends UsersEmailMapper implements RowMapper {
    @Override
    public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
        Users user = super.mapRow(rs, rowNum);
        user.setPassword(rs.getString("password"));

        return user;
    }
}

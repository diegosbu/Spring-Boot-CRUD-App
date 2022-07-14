package com.app.crud.model;

// code modelled off of: https://www.tutorialspoint.com/springjdbc/springjdbc_rowmapper.htm

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersMapper implements RowMapper {
    public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
        Users user = new Users();
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));

        return user;
    }
}

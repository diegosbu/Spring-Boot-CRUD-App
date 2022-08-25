package com.app.crud.model.users;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

// UsersIdMapper - RowMapper tht maps user id
public class UsersIdMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Users user = new Users();
        user.setId(rs.getInt("user_id"));

        return user;
    }
}

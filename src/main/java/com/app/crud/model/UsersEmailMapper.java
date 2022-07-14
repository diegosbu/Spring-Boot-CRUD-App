package com.app.crud.model;

// code modelled off of: https://www.tutorialspoint.com/springjdbc/springjdbc_rowmapper.htm

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersEmailMapper extends UsersMapper implements RowMapper {
    @Override
    public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
        Users user = super.mapRow(rs, rowNum);
        user.setEmail(rs.getString("email"));

        return user;
    }
}

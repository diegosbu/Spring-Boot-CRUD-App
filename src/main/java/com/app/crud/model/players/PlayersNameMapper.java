package com.app.crud.model.players;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

// PlayersNameMapper - RowMapper tht maps player id + full name
public class PlayersNameMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Players player = new Players();
        player.setId(rs.getInt("player_id"));
        player.setFirst_name(rs.getString("first_name"));
        player.setLast_name(rs.getString("last_name"));

        return player;
    }
}

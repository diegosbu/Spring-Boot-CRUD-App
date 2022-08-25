package com.app.crud.model.players;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

// PlayersIdMapper - RowMapper tht maps player id
public class PlayersIdMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Players player = new Players();
        player.setId(rs.getInt("player_id"));

        return player;
    }
}

package com.app.crud.repository;

import com.app.crud.model.players.Players;
import com.app.crud.model.players.PlayersNameMapper;
import com.app.crud.model.users.UsersIdMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlayersRepositoryImpl implements PlayersRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //  insert - inserts a player into the players table
    @Override
    public int insert(int playerID, String playerFirst, String playerLast, int userId) {
        return jdbcTemplate.update("INSERT INTO players(user_id, first_name, last_name, player_id) VALUES (?, ?, ?, ?)",
                userId, playerFirst, playerLast, playerID);
    }

    //  remove - removes specific player from players table corresponding to user's id
    @Override
    public int remove(int playerID, int userId) {
        return jdbcTemplate.update("DELETE FROM players WHERE user_id = ? AND player_id = ?", userId, playerID);
    }

    //  find - returns all players in the players table corresponding to a given user id
    @Override
    public List<Players> find(int userId) {
        return jdbcTemplate.query("SELECT player_id, first_name, last_name FROM players WHERE user_id = ?",
                new PlayersNameMapper(), userId);
    }

    //  exists - returns if a given player exists with the matching player/user id's
    @Override
    public boolean exists(int playerID, int userId) {
        return !(jdbcTemplate.query("SELECT user_id FROM players WHERE user_id = ? AND player_id = ?",
                new UsersIdMapper(), userId, playerID)).isEmpty();
    }
}

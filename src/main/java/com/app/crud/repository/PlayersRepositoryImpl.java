package com.app.crud.repository;

import com.app.crud.model.Players;
import com.app.crud.model.PlayersIdMapper;
import com.app.crud.model.UsersIdMapper;
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
    public int insert(int playerID, int userId) {
        return jdbcTemplate.update("INSERT INTO players(user_id, player_id) VALUES (?, ?)",
                userId, playerID);
    }

    //  remove - removes a player from the players table
    @Override
    public int remove(int playerID) {
        return 0;
    }

    //  find - returns all players in the players table corresponding to a given user id
    @Override
    public List<Players> find(int userId) {
        return jdbcTemplate.query("SELECT player_id FROM players WHERE user_id = ?",
                new PlayersIdMapper(), userId);
    }

    //  exists - returns if a given player exists with the matching player/user id's
    @Override
    public boolean exists(int playerID, int userId) {
        return !(jdbcTemplate.query("SELECT user_id FROM players WHERE user_id = ? AND player_id = ?",
                new UsersIdMapper(), userId, playerID)).isEmpty();
    }
}

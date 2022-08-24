package com.app.crud.repository;

import com.app.crud.model.Users;
import com.app.crud.model.UsersIdMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlayersRepositoryImpl implements PlayersRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(int playerID) {
        List<Users> users = jdbcTemplate.query("SELECT user_id FROM users WHERE email = ?", new UsersIdMapper(),
                SecurityContextHolder.getContext().getAuthentication().getName());

        return jdbcTemplate.update("INSERT INTO players(user_id, player_id) VALUES (?, ?)",
                users.get(0).getId(), playerID);
    }

    @Override
    public int remove(int playerID) {
        return 0;
    }

    @Override
    public boolean exists(int playerID) {
        List<Users> users = jdbcTemplate.query("SELECT user_id FROM users WHERE email = ?", new UsersIdMapper(),
                SecurityContextHolder.getContext().getAuthentication().getName());

        return !(jdbcTemplate.query("SELECT user_id FROM players WHERE user_id = ? AND player_id = ?",
                new UsersIdMapper(), users.get(0).getId(), playerID)).isEmpty();
    }
}

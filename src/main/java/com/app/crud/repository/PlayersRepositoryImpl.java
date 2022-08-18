package com.app.crud.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PlayersRepositoryImpl implements PlayersRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(int playerID) {
        return 0;
    }

    @Override
    public int remove(int playerID) {
        return 0;
    }

    @Override
    public boolean exists(int playerID) {
        return true;
    }
}

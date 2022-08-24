package com.app.crud.repository;

import com.app.crud.model.Players;

import java.util.List;

public interface PlayersRepository {
    int insert(int playerID, int userId);

    int remove(int playerID);

    List<Players> find(int userId);

    boolean exists(int playerID, int userId);
}

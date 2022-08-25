package com.app.crud.repository;

import com.app.crud.model.players.Players;

import java.util.List;

public interface PlayersRepository {
    int insert(int playerID, String playerFirst, String playerLast, int userId);

    int remove(int playerID, int userId);

    List<Players> find(int userId);

    boolean exists(int playerID, int userId);
}

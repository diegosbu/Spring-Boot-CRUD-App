package com.app.crud.service;

import com.app.crud.model.players.Players;

import java.util.List;

public interface PlayersService {
    int insert(int playerID, String playerFirst, String playerLast);

    int remove(int playerID);

    List<Players> find();

    boolean exists(int playerID);
}

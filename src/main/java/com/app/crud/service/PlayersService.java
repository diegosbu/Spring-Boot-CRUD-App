package com.app.crud.service;

import com.app.crud.model.Players;

import java.util.List;

public interface PlayersService {
    int insert(int playerID);

    int remove(int playerID);

    List<Players> find();

    boolean exists(int playerID);
}

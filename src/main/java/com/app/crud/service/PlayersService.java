package com.app.crud.service;

public interface PlayersService {
    int insert(int playerID);

    int remove(int playerID);

    boolean exists(int playerID);
}

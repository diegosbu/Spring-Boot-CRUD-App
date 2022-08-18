package com.app.crud.repository;

public interface PlayersRepository {
    int insert(int playerID);

    int remove(int playerID);

    boolean exists(int playerID);
}

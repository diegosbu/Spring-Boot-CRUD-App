package com.app.crud.service;

import com.app.crud.model.players.Players;
import com.app.crud.repository.PlayersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayersServiceImpl implements PlayersService {
    @Autowired
    PlayersRepository playersRepository;

    @Autowired
    UsersService usersService;

    //  insert - calls playersRepository to insert player in the user's favorites list
    @Override
    public int insert(int playerID, String playerFirst, String playerLast) {
        if (exists(playerID)) {
            return 0;
        } else {
            return playersRepository.insert(playerID, playerFirst, playerLast, usersService.findId());
        }
    }

    //  remove - calls playersRepository to delete a specific player from the user's favorites list
    @Override
    public int remove(int playerID) {
        return playersRepository.remove(playerID, usersService.findId());
    }

    // find - calls playersRepository to return the user's favorite players
    @Override
    public List<Players> find() {
        return playersRepository.find(usersService.findId());
    }

    // exists - calls playersRepository to return whether the player exists in the user's favorites list
    @Override
    public boolean exists(int playerID) {
        return playersRepository.exists(playerID, usersService.findId());
    }
}

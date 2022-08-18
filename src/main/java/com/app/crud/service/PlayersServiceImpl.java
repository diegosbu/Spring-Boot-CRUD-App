package com.app.crud.service;

import com.app.crud.repository.PlayersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayersServiceImpl implements PlayersService {
    @Autowired
    PlayersRepository playersRepository;

    @Override
    public int insert(int playerID) {
        if (exists(playerID)) {
            return 0;
        } else {
            return playersRepository.insert(playerID);
        }
    }

    @Override
    public int remove(int playerID) {
        return playersRepository.remove(playerID);
    }

    @Override
    public boolean exists(int playerID) {
        return playersRepository.exists(playerID);
    }
}

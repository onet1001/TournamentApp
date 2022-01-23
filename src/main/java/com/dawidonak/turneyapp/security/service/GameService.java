package com.dawidonak.turneyapp.security.service;

import com.dawidonak.turneyapp.domain.dto.GameDto;
import com.dawidonak.turneyapp.domain.mapper.GameMapper;
import com.dawidonak.turneyapp.repository.GameReopsitory;

import java.util.List;
import java.util.stream.Collectors;

public class GameService {
    private final GameReopsitory gameReopsitory;
    private final GameMapper gameMapper;

    public GameService(GameReopsitory gameReopsitory, GameMapper gameMapper) {
        this.gameReopsitory = gameReopsitory;
        this.gameMapper = gameMapper;
    }

    // dobranie przeciwników
    public void createPairs(){

    }

    //zmiana przeciwnika
    public void changeOpponent(){

    }

    //Wyświetlenie histori gier - zwrócenie wszystkich participantów z tym samym id użytkownika
    public List<GameDto> gameHistory(Long participantId){
        return gameReopsitory.findById(participantId)
                .stream()
                .map(game -> gameMapper.toDto(game))
                .collect(Collectors.toList());
    }
}

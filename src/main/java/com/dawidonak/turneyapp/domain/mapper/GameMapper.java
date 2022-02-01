package com.dawidonak.turneyapp.domain.mapper;

import com.dawidonak.turneyapp.domain.dto.GameDto;
import com.dawidonak.turneyapp.domain.entity.Game;
import org.springframework.stereotype.Component;

@Component
public class GameMapper {
    public GameDto toDto(Game game){
        return GameDto.builder()
                .gameId(game.getGameId())
                .tournamentId(game.getTournament().getTournamentId())
                .playerOneScore(game.getPlayerOneScore())
                .playerTwoScore(game.getPlayerTwoScore())
                .participantOneId(game.getParticipantOne().getParticipantId())
                .participantTwoId(game.getParticipantTwo().getParticipantId())
                .build();
    }

}

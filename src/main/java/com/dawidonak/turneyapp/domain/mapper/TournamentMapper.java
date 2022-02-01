package com.dawidonak.turneyapp.domain.mapper;

import com.dawidonak.turneyapp.domain.dto.TournamentDto;
import com.dawidonak.turneyapp.domain.entity.Tournament;
import org.springframework.stereotype.Component;


public class TournamentMapper {

    public static TournamentDto toDto(Tournament tournament){
        return TournamentDto.builder()
                .tournamentId(tournament.getTournamentId())
                .tournamentName(tournament.getTournamentName())
                .gameSystem(tournament.getGameSystem())
                .date(tournament.getDate())
                .description(tournament.getDescription())
                .build();
    }
}

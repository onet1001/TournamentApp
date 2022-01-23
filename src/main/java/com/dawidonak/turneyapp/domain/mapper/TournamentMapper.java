package com.dawidonak.turneyapp.domain.mapper;

import com.dawidonak.turneyapp.domain.dto.TournamentDto;
import com.dawidonak.turneyapp.domain.entity.Tournament;
import org.springframework.stereotype.Component;

@Component
public class TournamentMapper {

    public TournamentDto toDto(Tournament tournament){
        return TournamentDto.builder()
                .tournamentId(tournament.getTournamentId())
                .gameSystem(tournament.getGameSystem())
                .date(tournament.getDate())
                .description(tournament.getDescription())
                .build();
    }
}

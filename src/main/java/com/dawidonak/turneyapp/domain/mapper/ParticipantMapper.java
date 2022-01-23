package com.dawidonak.turneyapp.domain.mapper;

import com.dawidonak.turneyapp.domain.dto.ParticipantDto;
import com.dawidonak.turneyapp.domain.entity.Participant;
import org.springframework.stereotype.Component;

@Component
public class ParticipantMapper {
    public ParticipantDto toDto(Participant participant){
        return ParticipantDto.builder()
                .participantId(participant.getParticipantId())
                .userId(participant.getUser().getUserId())
                .tournamentId(participant.getTournament().getTournamentId())
                .armyId(participant.getArmy().getArmyId())
                .build();
    }
}

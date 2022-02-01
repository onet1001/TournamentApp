package com.dawidonak.turneyapp.domain.dto;

import com.dawidonak.turneyapp.domain.entity.Tournament;
import com.dawidonak.turneyapp.domain.entity.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ParticipantDto {
    private Long participantId;
    private Long userId;
    private Long tournamentId;
    private Long armyId;
    private Long tournamentScore;
}

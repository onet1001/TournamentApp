package com.dawidonak.turneyapp.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ParticipantDto {
    private Long participantId;
    private Long userId;
    private Long tournamentId;
    private Long armyId;
}
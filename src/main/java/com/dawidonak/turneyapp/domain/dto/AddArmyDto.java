package com.dawidonak.turneyapp.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddArmyDto {
    private Long tournamentId;
    private Long participantId;
    private String armyUrl;
}

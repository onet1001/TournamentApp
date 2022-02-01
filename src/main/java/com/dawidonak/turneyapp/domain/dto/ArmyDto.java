package com.dawidonak.turneyapp.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ArmyDto {

    private Long armyId;
    private String armyUrl;
    private Long tournamentId;
    private Long participantId;

}

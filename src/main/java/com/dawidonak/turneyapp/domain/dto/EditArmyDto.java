package com.dawidonak.turneyapp.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EditArmyDto {
    private Long armyId;
    private String armyUrl;
}

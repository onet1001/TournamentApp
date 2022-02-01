package com.dawidonak.turneyapp.domain.dto;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class AddParticipantDto {
    private Long userId;
    private Long tournamentId;
}

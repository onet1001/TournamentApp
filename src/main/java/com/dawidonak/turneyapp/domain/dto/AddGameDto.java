package com.dawidonak.turneyapp.domain.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddGameDto {
    private Long tournamentId;
    private Long participantOneId;
    private Long participantTwoId;
}

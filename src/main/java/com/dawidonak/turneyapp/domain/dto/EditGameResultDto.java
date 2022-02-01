package com.dawidonak.turneyapp.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EditGameResultDto {
    private Long gameId;
    private Long participantOneId;
    private Long participantTwoId;
    private Long participantOneScore;
    private Long participantTwoScore;
}

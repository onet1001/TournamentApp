package com.dawidonak.turneyapp.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ChangeGamePairs {
    private Long gameAId;
    private Long gameBId;
    private Long pairAParticipantOneId;
    private Long pairAParticipantTwoId;
    private Long pairBParticipantOneId;
    private Long pairBParticipantTwoId;
}

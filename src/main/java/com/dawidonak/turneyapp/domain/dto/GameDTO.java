package com.dawidonak.turneyapp.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GameDTO {
    private Long gameId;
    private Long tournamentId;
    private Long playerOneScore;
    private Long playerTwoScore;
    private Long participantOneId;
    private Long participantTwoId;
}

package com.dawidonak.turneyapp.domain.dto;

import com.dawidonak.turneyapp.domain.entity.Tournament;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class TournamentDTO {
    private Long tournamentId;
    private String gamesystem;
    private Date date;
    private String description;
}

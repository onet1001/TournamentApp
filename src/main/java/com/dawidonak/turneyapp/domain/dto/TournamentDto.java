package com.dawidonak.turneyapp.domain.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class TournamentDto {
    private Long tournamentId;
    private String gameSystem;
    private Date date;
    private String description;
}

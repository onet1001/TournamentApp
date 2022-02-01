package com.dawidonak.turneyapp.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashMap;

@AllArgsConstructor
@Data
@Builder
public class TournamentDto {
    private Long tournamentId;
    private String tournamentName;
    private String gameSystem;
    private Date date;
    private String description;


}

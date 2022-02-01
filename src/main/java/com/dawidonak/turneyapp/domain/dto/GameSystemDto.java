package com.dawidonak.turneyapp.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GameSystemDto {
    private Long gameSystemId;
    private String gameSystemName;

}

package com.dawidonak.turneyapp.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private Long userId;
    private String login;
    private String password;
    private String email;
    private String region;
}

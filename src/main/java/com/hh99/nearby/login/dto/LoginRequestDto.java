package com.hh99.nearby.login.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class LoginRequestDto {

    private String username;
    private String password;

}

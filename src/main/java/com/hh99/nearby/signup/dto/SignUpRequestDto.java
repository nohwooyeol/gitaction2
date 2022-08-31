package com.hh99.nearby.signup.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignUpRequestDto {

    private String email;
    private String nickname;
    private String password;
    private String profileImg;

}

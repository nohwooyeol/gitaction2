package com.hh99.nearby.login.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


@Builder
@AllArgsConstructor
@Getter
public class KakaoRequestDto {

    private Long id;
    private String nickname;


}

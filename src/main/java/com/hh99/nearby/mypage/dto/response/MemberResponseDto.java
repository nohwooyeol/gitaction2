package com.hh99.nearby.mypage.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class MemberResponseDto {

    private String nickname;

    private String profileImg;

    private String tier;

    private Long tierPoint;

    private String tierIcon;
}

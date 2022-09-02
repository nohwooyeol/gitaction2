package com.hh99.nearby.mypage.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@AllArgsConstructor
@Getter
public class MypageResponseDto {

    private Long totalTime; // 총 시간

    private List<MypageChallengeList> challengeList; //첼린징 리스트

}

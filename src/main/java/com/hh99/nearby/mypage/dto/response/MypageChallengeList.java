package com.hh99.nearby.mypage.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;
@Builder
@AllArgsConstructor
@Getter
public class MypageChallengeList {

    private String title; //첼린지 제목

    private String postImg; //첼린지이미지 url

    private Date startTime; //시작 시간

    private Long tagetTime; // 종료시간

    private Long tierPoint; // 점수

}

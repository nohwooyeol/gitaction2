package com.hh99.nearby.mypage.service;


import com.hh99.nearby.entity.Challenge;
import com.hh99.nearby.entity.Member;
import com.hh99.nearby.mypage.dto.request.MypageRequestDto;
import com.hh99.nearby.mypage.dto.response.MypageChallengeList;
import com.hh99.nearby.mypage.dto.response.MypageResponseDto;
import com.hh99.nearby.repository.ChallengeRepository;
import com.hh99.nearby.repository.MemberRepository;
import com.hh99.nearby.security.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class MypageService {

    private final MemberRepository memberRepository;

    private final ChallengeRepository challengeRepository;



//    private final ChallengeRepo

    @Transactional
    public ResponseEntity<?> myPage(@AuthenticationPrincipal UserDetails user) {
        Member member = memberRepository.findByEmail(user.getUsername()).get();

        List<Challenge> challengeList = challengeRepository.findAll();
        ArrayList<MypageChallengeList> mypageChallengeList = new ArrayList<>();
        for (Challenge challenge : challengeList) {
            mypageChallengeList.add(
                    MypageChallengeList.builder()
                            .title(challenge.getTitle())
                            .challengeImg(challenge.getChallengeImg())
                            .startTime(challenge.getStartTime())
                            .tagetTime(challenge.getTargetTime())
                            .endTime(challenge.getEndTime())
                            .limitPeople(challenge.getLimitPeople())
                            .build()
            );
        }


        return ResponseEntity.ok(MypageResponseDto.builder()
                .nickname(member.getNickname())
                .email(member.getEmail())
                .profileImg(member.getProfileImg())
                .level(100)
                .rank(100)
                .totalTime("시간")
//                .challengeLists()
//                .finishLists()
                .build());
    }

    @Transactional //수정서비스
    public ResponseEntity<?> memberUpdate(MypageRequestDto requestDto, @AuthenticationPrincipal UserDetails user) {
        Optional<Member> member = memberRepository.findByEmail(user.getUsername());
        member.get().update(requestDto);
        return ResponseEntity.ok(Map.of("msg","수정완료"));
    }


}

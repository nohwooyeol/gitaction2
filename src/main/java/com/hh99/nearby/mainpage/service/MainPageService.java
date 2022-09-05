package com.hh99.nearby.mainpage.service;

import com.hh99.nearby.entity.Challenge;
import com.hh99.nearby.entity.Member;
import com.hh99.nearby.entity.MemberChallenge;
import com.hh99.nearby.mainpage.dto.MainPageResponseDto;
import com.hh99.nearby.repository.ChallengeRepository;
import com.hh99.nearby.repository.MemberChallengeRepository;
import com.hh99.nearby.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MainPageService {

    private final MemberRepository memberRepository;

    private final MemberChallengeRepository memberChallengeRepository;

    private final ChallengeRepository challengeRepository;

    public ResponseEntity<?> getAllChallenge() {
        System.out.println("============================");
        List<Challenge> challenges = challengeRepository.findAll();
        List<MainPageResponseDto> allchallengelist = new ArrayList<>();
        for (Challenge challenge : challenges) {
            allchallengelist.add(
                    MainPageResponseDto.builder()
                            .title(challenge.getTitle())
                            .challengeImg(challenge.getChallengeImg())
                            .startDay(challenge.getStartDay())
                            .startTime(challenge.getStartTime())
                            .tagetTime(challenge.getTargetTime())
                            .endTime(challenge.getEndTime())
                            .limitPeople(challenge.getLimitPeople())
                            .build()
            );

        }
        System.out.println();

        return ResponseEntity.ok(allchallengelist);
    }


    public ResponseEntity<?> joinAllChallenge(UserDetails user) {
        Member member = memberRepository.findByEmail(user.getUsername()).get();

        //참가한 리스트 불러오는
        List<MemberChallenge> challengeList = memberChallengeRepository.findByMember(member);
        ArrayList<MainPageResponseDto> mypageChallengeList = new ArrayList<>();
        for (MemberChallenge challenge : challengeList) {
            mypageChallengeList.add(
                    MainPageResponseDto.builder()
                            .title(challenge.getChallenge().getTitle())
                            .challengeImg(challenge.getChallenge().getChallengeImg())
                            .startDay(challenge.getChallenge().getStartDay())
                            .startTime(challenge.getChallenge().getStartTime())
                            .tagetTime(challenge.getChallenge().getTargetTime())
                            .endTime(challenge.getChallenge().getEndTime())
                            .limitPeople(challenge.getChallenge().getLimitPeople())
                            .build()
            );
        }
        return ResponseEntity.ok(mypageChallengeList);
    }
}

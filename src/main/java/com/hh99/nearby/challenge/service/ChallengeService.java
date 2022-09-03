package com.hh99.nearby.challenge.service;

import com.hh99.nearby.challenge.dto.ChallengeRequestDto;
import com.hh99.nearby.entity.Challenge;
import com.hh99.nearby.entity.Member;
import com.hh99.nearby.signup.repository.ChallengeRepository;
import com.hh99.nearby.signup.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Map;
@Service
@RequiredArgsConstructor
public class ChallengeService {
    private final MemberRepository memberRepository;
    private final ChallengeRepository challengeRepository;
    public ResponseEntity<?> createChallenge(ChallengeRequestDto challengeRequestDto, UserDetails user) throws ParseException {
        Member member = memberRepository.findByEmail(user.getUsername()).get();

        LocalDate localDate = LocalDate.parse(challengeRequestDto.getStarttday());   //챌리지 시작일자
        LocalTime localTime = LocalTime.parse(challengeRequestDto.getStarttime());   //챌리지 시작시간

        //하루나 년도가 넘어가는 상황이 발생할수 있으므로 LocalDateTime객체로 만든후에 진행시간을 더해주는 방식으로 구현
        LocalDateTime localDateTime = localDate.atTime(localTime);
        localDateTime = localDateTime.plusMinutes(challengeRequestDto.getTargettime());

        LocalDateTime endTime = localDateTime;  //챌리지 종료시간

        String defaultImg = "https://user-images.githubusercontent.com/74406343/188258363-9a049b49-eba3-4518-9674-391d7887c5f8.png";

        challengeRepository.save(
                Challenge.builder()
                        .title(challengeRequestDto.getTitle())
                        .challengeimg(challengeRequestDto.getChallengeimg().equals("") ? "defaultImg" :challengeRequestDto.getChallengeimg())
                        .starttday(localDate)
                        .starttime(localTime)
                        .targettime(challengeRequestDto.getTargettime())
                        .endtime(endTime)
                        .limitpeople(challengeRequestDto.getLimit())
                        .content(challengeRequestDto.getContent())
                        .notice(challengeRequestDto.getNotice())
                        .Writer(member)
                        .build()
        );
        return ResponseEntity.ok(Map.of("msg","글작성이 완료되었습니다."));
    }
}

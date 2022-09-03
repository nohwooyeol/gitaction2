package com.hh99.nearby.challenge.controller;

import com.hh99.nearby.challenge.dto.ChallengeRequestDto;
import com.hh99.nearby.challenge.service.ChallengeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RequiredArgsConstructor
@RestController
public class ChallengeController {
    private final ChallengeService challengeService;

    @PostMapping("/api/Challenge")  // <form> 요소가 파일이나 이미지를 서버로 전송할 때 주로 사용!!  HttpServletRequest request 추가해줘야함.
    public ResponseEntity<?> createChallenge(@RequestBody ChallengeRequestDto challengeRequestDto, @AuthenticationPrincipal UserDetails user) throws ParseException {
       return challengeService.createChallenge(challengeRequestDto, user);
    }

}

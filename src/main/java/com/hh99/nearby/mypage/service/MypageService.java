package com.hh99.nearby.mypage.service;


import com.hh99.nearby.entity.Member;
import com.hh99.nearby.mypage.dto.request.MypageRequestDto;
import com.hh99.nearby.mypage.dto.response.MemberResponseDto;
import com.hh99.nearby.repository.MemberRepository;
import com.hh99.nearby.security.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class MypageService {

    private final MemberRepository memberRepository;


    private final TokenProvider tokenProvider;



//    private final ChallengeRepo

    @Transactional
    public ResponseEntity<?> myPage(@AuthenticationPrincipal UserDetails user) {





        return ResponseEntity.ok("가랏!");
    }

    @Transactional //수정서비스
    public ResponseEntity<?> memberUpdate(MypageRequestDto requestDto, @AuthenticationPrincipal UserDetails user) {
        Optional<Member> member = memberRepository.findByEmail(user.getUsername());
        member.get().update(requestDto);
        return ResponseEntity.ok(Map.of("msg","수정완료"));
    }


}

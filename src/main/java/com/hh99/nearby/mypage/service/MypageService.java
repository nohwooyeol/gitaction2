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

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class MypageService {

    private final MemberRepository memberRepository;


    private final TokenProvider tokenProvider;



//    private final ChallengeRepo

    @Transactional
    public ResponseEntity<?> myPage(@AuthenticationPrincipal UserDetails user) {

        //리스트를 기준으로
        //user로 Member_post에서 데이터 받아서 리스트에 담기



        return ResponseEntity.ok("가랏!");
    }

    @Transactional //수정서비스
    public ResponseEntity<?> memberUpdate(MypageRequestDto requestDto, @AuthenticationPrincipal UserDetails user) {
        Member member = isPresentMember(user);
        member.update(requestDto);
        MemberResponseDto.builder()
                .nickname(member.getNickname())
                .profileImg(member.getProfileImg())
                .tier("골드3")
                .tierPoint(100L)
                .tierIcon("https")
                .build();
        return ResponseEntity.ok("바뀐다");
    }


    @Transactional(readOnly = true)
    public Member isPresentMember(UserDetails user) {
        Optional<Member> member = memberRepository.findByNickname(user.getUsername());
        return member.orElse(null);
    }


}

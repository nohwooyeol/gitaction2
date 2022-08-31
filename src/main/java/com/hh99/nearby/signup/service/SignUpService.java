package com.hh99.nearby.signup.service;


import com.hh99.nearby.signup.dto.SignUpRequestDto;
import com.hh99.nearby.entity.Member;
import com.hh99.nearby.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SignUpService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    //회원가입
    @Transactional
    public ResponseEntity<?> createMember(SignUpRequestDto requestDto) {
        //email check
        if (null != isPresentMemberByEmail(requestDto.getEmail())) {
            return ResponseEntity.badRequest().body(Map.of("msg","Already existing email."));
        }
        //nickname check
        if (null != isPresentMemberByNickname(requestDto.getNickname())) {
            return ResponseEntity.badRequest().body(Map.of("msg","Already existing nickname."));
        }
        if (requestDto.getEmail().isBlank()) {
            return ResponseEntity.badRequest().body(Map.of("msg","Please write proper email address to email field."));
        }
        if (requestDto.getPassword().isBlank()) {
            return ResponseEntity.badRequest().body(Map.of("msg","Please write proper password to Password field."));
        }

        Member member = Member.builder()
                .email(requestDto.getEmail())
                .nickname(requestDto.getNickname())
                .password(passwordEncoder.encode(requestDto.getPassword()))
                .profileImg(requestDto.getProfileImg())
                .build();

        memberRepository.save(member);
        return ResponseEntity.ok().body(Map.of("msg","Successfully sign up."));
    }

    @Transactional(readOnly = true)
    public Member isPresentMemberByEmail(String email) {
        Optional<Member> optionalMember = memberRepository.findByEmail(email);
        return optionalMember.orElse(null);
    }

    @Transactional(readOnly = true)
    public Member isPresentMemberByNickname(String nickname) {
        Optional<Member> optionalMember = memberRepository.findByNickname(nickname);
        return optionalMember.orElse(null);
    }

}

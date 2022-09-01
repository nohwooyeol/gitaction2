//package com.hh99.nearby.signup.service;
//
//
//import com.hh99.nearby.ResponseDto;
//import com.hh99.nearby.signup.dto.SignUpRequestDto;
//import com.hh99.nearby.entity.Member;
//import com.hh99.nearby.repository.MemberRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Optional;
//
//@RequiredArgsConstructor
//@Service
//public class SignUpService {
//
//    private final MemberRepository memberRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    //회원가입
//    @Transactional
//    public ResponseDto<?> createMember(SignUpRequestDto requestDto) {
//        //username check
//        if (null != isPresentMemberByUsername(requestDto.getUsername())) {
//            return ResponseDto.fail("400", "Already existing username.");
//        }
//
//        //“Please write proper password to Password field.”
//        if (requestDto.getPassword().isBlank()) {
//            return ResponseDto.fail("400", "Please write proper password to Password field.");
//        }
//
//        Member member = Member.builder()
//                .username(requestDto.getUsername())
//                .password(passwordEncoder.encode(requestDto.getPassword()))
//                .build();
//
//        memberRepository.save(member);
//        return ResponseDto.success(null, "200", "Successfully sign up.");
//    }
//
//    @Transactional(readOnly = true)
//    public Member isPresentMemberByUsername(String username) {
//        Optional<Member> optionalMember = memberRepository.findByUsername(username);
//        return optionalMember.orElse(null);
//    }
//
//}

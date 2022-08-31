package com.hh99.nearby.login.service;

import com.hh99.nearby.ResponseDto;
import com.hh99.nearby.entity.Member;
import com.hh99.nearby.login.dto.LoginRequestDto;
import com.hh99.nearby.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LoginService {

    private final MemberRepository memberRepository;

    private final PasswordEncoder passwordEncoder;

    @Transactional
    public ResponseDto<?> login(LoginRequestDto requestDto, HttpServletResponse response) {
        Member member = isPresentMemberByUsername(requestDto.getUsername());
        if (null == member) {
            return ResponseDto.fail("400", "Not existing email or wrong password");
        }

        if (!member.validatePassword(passwordEncoder, requestDto.getPassword())) {
            return ResponseDto.fail("400", "Not existing email or wrong password");
        }

//        TokenDto tokenDto = tokenProvider.generateTokenDto(member);
//        tokenToHeaders(tokenDto, response);

        return ResponseDto.success(null, "200", "Successfully logged in");
    }

    public ResponseDto<?> logout(HttpServletRequest request) {

//        Member member = isPresentMemberByUsername(requestDto.getUsername());
//        if (null == member) {
//            return ResponseDto.fail("400",
//                    "사용자를 찾을 수 없습니다.");
//        }
//        tokenProvider.deleteRefreshToken(member);
//
       return ResponseDto.success(null, "200", "Successfully logged out");
    }

    @Transactional(readOnly = true)
    public Member isPresentMemberByUsername(String username) {
        Optional<Member> optionalMember = memberRepository.findByUsername(username);
        return optionalMember.orElse(null);
    }

//    public void tokenToHeaders(TokenDto tokenDto, HttpServletResponse response) {
//        response.addHeader("Authorization", "Bearer " + tokenDto.getAccessToken());
////        response.addHeader("RefreshToken", tokenDto.getRefreshToken());
//        response.addHeader("Access-Token-Expire-Time", tokenDto.getAccessTokenExpiresIn().toString());
//    }
}

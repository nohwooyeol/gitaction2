package com.hh99.nearby.signup.contorller;

import com.hh99.nearby.ResponseDto;
import com.hh99.nearby.signup.dto.SignUpRequestDto;
import com.hh99.nearby.signup.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class SignUpController {

    private final SignUpService signUpService;

    //회원가입
    @RequestMapping(value = "/api/signup", method = RequestMethod.POST)
    public ResponseDto<?> signup(@RequestBody SignUpRequestDto requestDto) {
        return signUpService.createMember(requestDto);
    }

}

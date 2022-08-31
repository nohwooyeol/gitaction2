package com.hh99.nearby.signup.contorller;

import com.hh99.nearby.signup.dto.SignUpRequestDto;
import com.hh99.nearby.signup.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class SignUpController {

    private final SignUpService signUpService;

    //회원가입
    @RequestMapping(value = "/api/signup", method = RequestMethod.POST)
    public ResponseEntity<?> signup(@RequestBody @Valid SignUpRequestDto requestDto) {
        return signUpService.createMember(requestDto);
    }

}

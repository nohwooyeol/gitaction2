package com.hh99.nearby.signup.contorller;

import com.hh99.nearby.signup.dto.SignUpRequestDto;
import com.hh99.nearby.signup.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@RequiredArgsConstructor
@RestController
public class SignUpController {

    private final SignUpService signUpService;

    //회원가입
    @RequestMapping(value = "/api/signup", method = RequestMethod.POST)
    public ResponseEntity<?> signup(@RequestBody @Valid SignUpRequestDto requestDto) throws MessagingException {
        return signUpService.createMember(requestDto);
    }
    //이메일 인증
    @RequestMapping(value = "/api/email",method = RequestMethod.GET)
    public ResponseEntity<?> emailCheck(@RequestParam("id") Long id,HttpServletResponse response) throws IOException {
        response.sendRedirect("http://localhost:8080/");
        return signUpService.EmailCheck(id);
    }
}

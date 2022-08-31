package com.hh99.nearby.login.controller;

import com.hh99.nearby.login.dto.LoginRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@RestController
public class LoginController {

    @PostMapping("/api/login")
    public ResponseEntity<?> login (){

        return ResponseEntity.ok("");
    }

    //로그인
    @RequestMapping(value = "/api/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody LoginRequestDto requestDto, HttpServletResponse response) {
//        return memberService.login(requestDto, response);
        return ResponseEntity.ok("");
    }

    //로그아웃
    @RequestMapping(value = "/api/logout", method = RequestMethod.POST)
    public ResponseEntity<?> logout(@RequestBody LoginRequestDto requestDto, HttpServletResponse response) {
//        return memberService.logout(request);
        return ResponseEntity.ok("");
    }
}

package com.hh99.nearby.login.controller;

import com.hh99.nearby.login.dto.LoginRequestDto;
import com.hh99.nearby.login.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@RestController
public class LoginController {

    private final LoginService loginService;


    @PostMapping("/api/login")
    public ResponseEntity<?> login (){
        return ResponseEntity.ok("");
    }

    //로그인
    @RequestMapping(value = "/api/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody LoginRequestDto requestDto, HttpServletResponse response) {
        loginService.login(requestDto, response);
        return ResponseEntity.ok("");
    }

    //로그아웃
    @RequestMapping(value = "/api/logout", method = RequestMethod.POST)
    public ResponseEntity<?> logout(@RequestBody LoginRequestDto requestDto, HttpServletResponse response) {
         loginService.logout(requestDto);
        return ResponseEntity.ok("");
    }
}

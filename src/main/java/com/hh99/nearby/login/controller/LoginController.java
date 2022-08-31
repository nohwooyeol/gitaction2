package com.hh99.nearby.login.controller;

import com.hh99.nearby.login.service.KakaoLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor
@RestController
public class LoginController {

    private final KakaoLoginService kakaoLoginService;


    @PostMapping("/api/login")
    public ResponseEntity<?> login (){

        return ResponseEntity.ok("");
    }

    @GetMapping("/api/kakaologin")
    public ResponseEntity<?> kakaoLogin(@RequestParam String code){
        System.out.println(code);
        String kakao = kakaoLoginService.getKaKaoAccessToken(code);
        System.out.println(kakao);
        return ResponseEntity.ok("");
    }
}

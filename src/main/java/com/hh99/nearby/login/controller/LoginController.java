package com.hh99.nearby.login.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor
@RestController
public class LoginController {

    @PostMapping("/api/login")
    public ResponseEntity<?> login (){

        return ResponseEntity.ok("");
    }
}

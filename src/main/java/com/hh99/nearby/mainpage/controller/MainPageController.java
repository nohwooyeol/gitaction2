package com.hh99.nearby.mainpage.controller;

import com.hh99.nearby.mainpage.service.MainPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MainPageController {

    private final MainPageService mainPageService;

    //모든 리스트 불러오는 API (무한스크롤 미구현)
    @GetMapping("/api/posts")
    public ResponseEntity<?> getAllChallenge(){
        return mainPageService.getAllChallenge();
    }

    //참가신청한 리스트 불러오는 API
    @GetMapping("/api/joinposts")
    public ResponseEntity<?> joinAllChallenge(@AuthenticationPrincipal UserDetails user){
        return mainPageService.joinAllChallenge(user);
    }
}

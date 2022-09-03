package com.hh99.nearby.detail.controller;

import com.hh99.nearby.detail.service.DetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class DetailController {

    public final DetailService detailService;

    //상세 모달
    @GetMapping("/api/challenge/{id}")
    public ResponseEntity<?> detailModal(@PathVariable Long id){
        return detailService.detailModal(id);
    }
}

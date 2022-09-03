package com.hh99.nearby.detail.service;

import com.hh99.nearby.detail.dto.DetailResponseDto;
import com.hh99.nearby.entity.Challenge;
import com.hh99.nearby.signup.repository.ChallengeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DetailService {
    private final ChallengeRepository challengeRepository;

    @Transactional
    public ResponseEntity<?> detailModal(@PathVariable Long id) {
        Challenge challenge = isPresentChallenge(id);
        if (challenge == null){
            return ResponseEntity.badRequest().body(Map.of("msg","잘못된 챌린지 번호"));
        }
        DetailResponseDto detailResponseDto = DetailResponseDto.builder()
                .title(challenge.getTitle())
                .challengeimg(challenge.getChallengeimg())
                .startday(challenge.getStarttday())
                .starttime(challenge.getStarttime())
                .targettime(challenge.getTargettime())
                .endtime(challenge.getEndtime())
                .limitpeople(challenge.getLimitpeople())
                .content(challenge.getContent())
                .notice(challenge.getNotice())
                .writer(challenge.getWriter())
                .build();
        return ResponseEntity.ok().body(Map.of("detailModal", detailResponseDto, "msg", "상세모달 조회 완료"));
    }

    @Transactional(readOnly = true)
    public Challenge isPresentChallenge(Long id) {
        Optional<Challenge> optionalChallenge = challengeRepository.findById(id);
        return optionalChallenge.orElse(null);
    }
}


package com.hh99.nearby.signup.repository;

import com.hh99.nearby.entity.MemberChallenge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberChallengeRepository extends JpaRepository<MemberChallenge,Long> {
    Optional<MemberChallenge> findByMember_IdAndChallenge_Id(Long memberId,Long ChallengeId);
}

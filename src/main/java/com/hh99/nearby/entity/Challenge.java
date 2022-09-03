package com.hh99.nearby.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Challenge extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title; //챌리지 제목

    @Column()
    private String challengeimg; //챌리지 대표 이미지

    @Column(nullable = false)
    private LocalDate starttday; //챌리지 시작 일자

    @Column(nullable = false)
    private LocalTime starttime; //챌리지 시작 시간

    @Column(nullable = false)
    private Long targettime; //챌린지 진행시간

    @Column(nullable = false)
    private LocalDateTime endtime; //챌린지 종료시간

    @Column(nullable = false)
    private Long limitpeople; //챌린지 제한인원

    @Column(nullable = false)
    private String content; //챌린지 내용

    @Column()
    private String notice; //챌린지 공지사항

    @JoinColumn(name = "member_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Member Writer;

    @OneToMany(mappedBy="challenge", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MemberChallenge> memberChallengeList;




    //    public void update(PostRequestDto postRequestDto,Member member){
//    public void update(PostRequestDto postRequestDto){
//        this.content = postRequestDto.getContent();
////        this.member = member;
//    }

//    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Likes> postLikeList;
//
//    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Hashtags> hashtagsList;
//
//    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Image> imageList;
//
//    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Comment> commentList;


}
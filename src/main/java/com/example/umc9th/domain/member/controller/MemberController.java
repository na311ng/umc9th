package com.example.umc9th.domain.member.controller;

import com.example.umc9th.domain.member.entitiy.Member;
import com.example.umc9th.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/{id}")
    public Optional<Member> getMemberProfile(@PathVariable Long id){
        return memberService.getMemberProfile(id);
    }
}

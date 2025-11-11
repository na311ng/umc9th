package com.example.umc9th.domain.member.controller;

import com.example.umc9th.domain.member.dto.req.MemberReqDTO;
import com.example.umc9th.domain.member.dto.res.MemberResDTO;
import com.example.umc9th.domain.member.entitiy.Member;
import com.example.umc9th.domain.member.service.MemberService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ApiResponse<MemberResDTO> createMember(@RequestBody MemberReqDTO memberReqDTO){
        return ApiResponse.onSuccess(
                GeneralSuccessCode.CREATED,
                memberService.createMember(memberReqDTO)
        );
    }
}

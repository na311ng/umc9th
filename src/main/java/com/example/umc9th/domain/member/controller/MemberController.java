package com.example.umc9th.domain.member.controller;

import com.example.umc9th.domain.member.dto.req.MemberReqDTO;
import com.example.umc9th.domain.member.dto.res.MemberResDTO;
import com.example.umc9th.domain.member.entitiy.Member;
import com.example.umc9th.domain.member.service.MemberService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralErrorCode;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import com.example.umc9th.global.apiPayload.exception.GeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    // 회원 프로필 조회
    @GetMapping("/{id}")
    public ApiResponse<MemberResDTO> getMemberProfile(@PathVariable Long id){
        MemberResDTO member = memberService.getMemberProfile(id);
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, member);
    }

    // 회원 가입
    @PostMapping("/signup")
    public ApiResponse<MemberResDTO> createMember(@RequestBody MemberReqDTO memberReqDTO){
        return ApiResponse.onSuccess(
                GeneralSuccessCode.CREATED,
                memberService.createMember(memberReqDTO)
        );
    }
}

package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.mission.dto.res.MemberMissionResponse;
import com.example.umc9th.domain.mission.service.MemberMissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MemberMissionController {
    private final MemberMissionService memberMissionService;

    @GetMapping("/my")
    public Page<MemberMissionResponse> getMyMissions(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ){
        Long loginMemberId = 1L; // TODO: 실제는 JWT 토큰에서 추출
        return memberMissionService.getMyMissions(loginMemberId, page, size);
    }
}

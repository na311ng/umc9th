package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.mission.dto.req.MemberMissionCompleteReqDTO;
import com.example.umc9th.domain.mission.dto.res.MemberMissionCompleteResDTO;
import com.example.umc9th.domain.mission.dto.res.MemberMissionResDTO;
import com.example.umc9th.domain.mission.service.MemberMissionService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/missions")
public class MemberMissionController {
    private final MemberMissionService memberMissionService;

    @GetMapping("/my")
    public ApiResponse<MemberMissionResDTO.MemberMissionPageDTO> getMyMissions(
            @RequestParam(required = false) String status,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ){
        Long loginMemberId = 1L; // TODO: 실제는 JWT 토큰에서 추출
        Page<MemberMissionResDTO.MemberMissionInfoDTO> missionsPage =
                memberMissionService.getMyMissions(loginMemberId, status, page, size);

        return ApiResponse.onSuccess(
                GeneralSuccessCode.OK,
                MemberMissionResDTO.MemberMissionPageDTO.fromPage(missionsPage)
        );
    }

    @PatchMapping("/{userMissionId}/complete")
    public ApiResponse<MemberMissionCompleteResDTO> completeMission(
            @PathVariable Long userMissionId,
            @RequestBody MemberMissionCompleteReqDTO request
    ){
        return ApiResponse.onSuccess(
                GeneralSuccessCode.OK,
                memberMissionService.completeMission(userMissionId, request.isComplete())
        );
    }
}

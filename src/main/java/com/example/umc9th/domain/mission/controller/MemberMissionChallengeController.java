package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.mission.dto.req.MemberMissionChallengeReqDTO;
import com.example.umc9th.domain.mission.dto.res.MemberMissionChallengeResDTO;
import com.example.umc9th.domain.mission.service.MemberMissionChallengeService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/missions")
public class MemberMissionChallengeController {

    private final MemberMissionChallengeService memberMissionChallengeService;

    @PostMapping("/{missionId}/challenge")
    public ApiResponse<MemberMissionChallengeResDTO> challengeMission(
            @PathVariable Long missionId,
            @RequestBody(required = false)MemberMissionChallengeReqDTO dto
    ){
        if(dto == null) dto = MemberMissionChallengeReqDTO.builder().isComplete(false).build();

        return ApiResponse.onSuccess(
                GeneralSuccessCode.CREATED,
                memberMissionChallengeService.challengeMission(missionId, dto)
        );
    }
}

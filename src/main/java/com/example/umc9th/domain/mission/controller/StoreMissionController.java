package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.mission.dto.req.MissionCreateReqDTO;
import com.example.umc9th.domain.mission.dto.res.MissionCreateResDTO;
import com.example.umc9th.domain.mission.service.MissionCreateService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/stores")
public class StoreMissionController {

    private final MissionCreateService missionCreateService;

    @PostMapping("/{storeId}/missions")
    public ApiResponse<MissionCreateResDTO> createMission(
            @PathVariable Long storeId,
            @RequestBody MissionCreateReqDTO request
    ){
        return ApiResponse.onSuccess(
                GeneralSuccessCode.CREATED,
                missionCreateService.createMission(storeId, request)
        );
    }
}

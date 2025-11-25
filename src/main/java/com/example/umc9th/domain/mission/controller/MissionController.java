package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.mission.dto.MissionHomeResponse;
import com.example.umc9th.domain.mission.service.MissionService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {
    private final MissionService missionService;

    // 지역별 미션 조회
    @GetMapping
    public ApiResponse<Page<MissionHomeResponse>>  getMissionsByLocation(
            @RequestParam Long locationId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Page<MissionHomeResponse> missions = missionService.getMissionsByLocation(locationId, PageRequest.of(page, size));
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, missions);
    }
}

package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.mission.dto.res.MissionResDTO;
import com.example.umc9th.domain.mission.service.MissionService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/missions")
public class MissionController {
    private final MissionService missionService;

    @GetMapping
    public ApiResponse<MissionResDTO.MissionPageResDTO> getMissionsByLocation(
            @RequestParam Long locationId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Page<MissionResDTO.MissionHomeResDTO> missionsPage =
                missionService.getMissionsByLocation(locationId, PageRequest.of(page, size));

        return ApiResponse.onSuccess(
                GeneralSuccessCode.OK,
                MissionResDTO.MissionPageResDTO.fromPage(missionsPage)
        );
    }
}

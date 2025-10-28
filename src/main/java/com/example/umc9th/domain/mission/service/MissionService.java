package com.example.umc9th.domain.mission.service;

import com.example.umc9th.domain.mission.dto.MissionHomeResponse;
import com.example.umc9th.domain.mission.repository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionService {
    private final MissionRepository missionRepository;

    public Page<MissionHomeResponse> getMissionsByLocation(Long locationId, Pageable pageable) {
        return missionRepository.findMissionsByLocationId(locationId, pageable);
    }
}

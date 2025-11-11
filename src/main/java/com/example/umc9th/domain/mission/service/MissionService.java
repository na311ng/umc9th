package com.example.umc9th.domain.mission.service;

import com.example.umc9th.domain.mission.dto.res.MissionResDTO;
import com.example.umc9th.domain.mission.repository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionService {
    private final MissionRepository missionRepository;

    public Page<MissionResDTO.MissionHomeResDTO> getMissionsByLocation(Long locationId, Pageable pageable) {
        return missionRepository.findMissionsByLocationId(locationId, pageable);
    }
}

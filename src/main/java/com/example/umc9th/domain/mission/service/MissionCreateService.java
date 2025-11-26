package com.example.umc9th.domain.mission.service;

import com.example.umc9th.domain.mission.converter.MissionConverter;
import com.example.umc9th.domain.mission.dto.req.MissionCreateReqDTO;
import com.example.umc9th.domain.mission.dto.res.MissionCreateResDTO;
import com.example.umc9th.domain.mission.entitiy.Mission;
import com.example.umc9th.domain.mission.repository.MissionRepository;
import com.example.umc9th.domain.store.entitiy.Store;
import com.example.umc9th.domain.store.repository.StoreRepository;
import com.example.umc9th.global.apiPayload.code.GeneralErrorCode;
import com.example.umc9th.global.apiPayload.exception.GeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MissionCreateService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    @Transactional
    public MissionCreateResDTO createMission(Long storeId, MissionCreateReqDTO dto){
        Store store = storeRepository.findById(storeId)
                .orElseThrow(()-> new GeneralException(GeneralErrorCode.NOT_FOUND));

        Mission mission = MissionConverter.toEntity(dto, store);
        Mission saved = missionRepository.save(mission);

        return MissionConverter.toCreateResDTO(saved);
    }
}

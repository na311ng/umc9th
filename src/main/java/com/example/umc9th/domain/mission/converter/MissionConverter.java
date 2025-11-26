package com.example.umc9th.domain.mission.converter;

import com.example.umc9th.domain.mission.dto.req.MissionCreateReqDTO;
import com.example.umc9th.domain.mission.dto.res.MissionCreateResDTO;
import com.example.umc9th.domain.mission.entitiy.Mission;
import com.example.umc9th.domain.store.entitiy.Store;

import java.time.LocalDate;

public class MissionConverter {

    // DTO -> Entity
    public static Mission toEntity(MissionCreateReqDTO dto, Store store){
        return Mission.builder()
                .duration(LocalDate.parse(dto.getDuration()))
                .conditional(dto.getConditional())
                .point(dto.getPoint())
                .store(store)
                .build();
    }
    // Entity -> DTO
    public static MissionCreateResDTO toResDTO(Mission mission){
        return MissionCreateResDTO.builder()
                .missionId(mission.getId())
                .storeName(mission.getStore().getName())
                .duration(mission.getDuration().toString())
                .conditional(mission.getConditional())
                .point(mission.getPoint())
                .build();
    }
}

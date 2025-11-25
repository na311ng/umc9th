package com.example.umc9th.domain.mission.converter;

import com.example.umc9th.domain.mission.dto.req.MissionCreateReqDTO;
import com.example.umc9th.domain.mission.dto.res.MissionCreateResDTO;
import com.example.umc9th.domain.mission.entitiy.Mission;
import com.example.umc9th.domain.store.entitiy.Store;

public class MissionConverter {

    public static Mission toEntity(MissionCreateReqDTO dto, Store store){
        return Mission.builder()
                .store(store)
                .missionName(dto.getMissionName())
                .conditional(dto.getConditional())
                .point(dto.getPoint())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .build();
    }

    public static MissionCreateResDTO toCreateResDTO(Mission mission){
        return MissionCreateResDTO.builder()
                .missionId(mission.getId())
                .storeId(mission.getStore().getId())
                .message("가게 미션이 성공적으로 등록되었습니다.")
                .build();
    }
}

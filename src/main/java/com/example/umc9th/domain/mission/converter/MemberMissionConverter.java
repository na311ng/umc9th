package com.example.umc9th.domain.mission.converter;

import com.example.umc9th.domain.mission.dto.res.MemberMissionCreateResDTO;
import com.example.umc9th.domain.mission.entitiy.mapping.MemberMission;

public class MemberMissionConverter {

    public static MemberMissionCreateResDTO toResDTO(MemberMission memberMission){
        return MemberMissionCreateResDTO.builder()
                .memberMissionId(memberMission.getId())
                .memberName(memberMission.getMember().getName())
                .storeName(memberMission.getMission().getStore().getName())
                .conditional(memberMission.getMission().getConditional())
                .point(memberMission.getMission().getPoint())
                .duration(memberMission.getMission().getDuration().toString())
                .isComplete(memberMission.isComplete())
                .build();
    }
}

package com.example.umc9th.domain.mission.converter;

import com.example.umc9th.domain.member.entitiy.Member;
import com.example.umc9th.domain.mission.dto.req.MemberMissionChallengeReqDTO;
import com.example.umc9th.domain.mission.dto.res.MemberMissionChallengeResDTO;
import com.example.umc9th.domain.mission.entitiy.Mission;
import com.example.umc9th.domain.mission.entitiy.mapping.MemberMission;

public class MemberMissionConverter {

    public static MemberMission toEntity(MemberMissionChallengeReqDTO dto, Member member, Mission mission) {
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .isComplete(dto.isComplete())
                .build();
    }

    public static MemberMissionChallengeResDTO toChallengeResDTO(MemberMission entity) {
        return MemberMissionChallengeResDTO.builder()
                .memberMissionId(entity.getId())
                .missionId(entity.getMission().getId())
                .message("미션 도전이 등록되었습니다. ")
                .build();
    }
}

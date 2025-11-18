package com.example.umc9th.domain.mission.service;

import com.example.umc9th.domain.member.entitiy.Member;
import com.example.umc9th.domain.member.repository.MemberRepository;
import com.example.umc9th.domain.mission.converter.MemberMissionConverter;
import com.example.umc9th.domain.mission.dto.req.MemberMissionChallengeReqDTO;
import com.example.umc9th.domain.mission.dto.res.MemberMissionChallengeResDTO;
import com.example.umc9th.domain.mission.entitiy.Mission;
import com.example.umc9th.domain.mission.entitiy.mapping.MemberMission;
import com.example.umc9th.domain.mission.repository.MemberMissionRepository;
import com.example.umc9th.domain.mission.repository.MissionRepository;
import com.example.umc9th.global.apiPayload.code.GeneralErrorCode;
import com.example.umc9th.global.apiPayload.exception.GeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberMissionChallengeService {

    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;

    @Transactional
    public MemberMissionChallengeResDTO challengeMission(Long missionId, MemberMissionChallengeReqDTO dto){
        Member member = memberRepository.findById(1L)
                .orElseThrow(()->new GeneralException(GeneralErrorCode.NOT_FOUND));

        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(()->new GeneralException(GeneralErrorCode.NOT_FOUND));

        MemberMission memberMission = MemberMissionConverter.toEntity(dto, member, mission);
        MemberMission saved = memberMissionRepository.save(memberMission);

        return MemberMissionConverter.toChallengeResDTO(saved);
    }
}

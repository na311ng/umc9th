package com.example.umc9th.domain.mission.service;

import com.example.umc9th.domain.mission.dto.res.MemberMissionCompleteResDTO;
import com.example.umc9th.domain.mission.dto.res.MemberMissionResDTO;
import com.example.umc9th.domain.mission.entitiy.mapping.MemberMission;
import com.example.umc9th.domain.mission.repository.MemberMissionRepository;
import com.example.umc9th.global.apiPayload.code.GeneralErrorCode;
import com.example.umc9th.global.apiPayload.exception.GeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberMissionService {
    private final MemberMissionRepository memberMissionRepository;

    public Page<MemberMissionResDTO.MemberMissionInfoDTO> getMyMissions(Long memberId, String status, int page, int size) {
        return memberMissionRepository.findeMemberMissionByMemeberId(memberId, status, PageRequest.of(page, size));
    }

    @Transactional
    public MemberMissionCompleteResDTO completeMission(Long memberMissionId, boolean isComplete) {
        // 1. MemberMission 조회
        MemberMission memberMission = memberMissionRepository.findById(memberMissionId)
                .orElseThrow(() -> new GeneralException(GeneralErrorCode.NOT_FOUND));

        // 2. 이미 완료된 경우
        if (memberMission.isComplete() && isComplete) {
            return MemberMissionCompleteResDTO.builder()
                    .userMissionId(memberMission.getId())
                    .status("COMPLETED")
                    .message("이미 완료된 미션입니다.")
                    .build();
        }

        // 3. 완료 처리
        if (isComplete) {
            memberMission.markAsCompleted();
            return MemberMissionCompleteResDTO.builder()
                    .userMissionId(memberMission.getId())
                    .status("COMPLETED")
                    .message("미션이 성공 처리되었습니다.")
                    .build();
        }

        // 4. 완료 해제 시 (옵션)
        return MemberMissionCompleteResDTO.builder()
                .userMissionId(memberMission.getId())
                .status("ONGOING")
                .message("미션이 완료되지 않았습니다.")
                .build();
    }
}

package com.example.umc9th.domain.mission.service;

import com.example.umc9th.domain.mission.dto.res.MemberMissionResDTO;
import com.example.umc9th.domain.mission.repository.MemberMissionRepository;
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
}

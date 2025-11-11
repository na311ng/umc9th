package com.example.umc9th.domain.mission.service;

import com.example.umc9th.domain.mission.dto.res.MemberMissionResponse;
import com.example.umc9th.domain.mission.repository.MemberMissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberMissionService {
    private final MemberMissionRepository memberMissionRepository;

    public Page<MemberMissionResponse> getMyMissions(Long memberId, int page, int size) {
        return memberMissionRepository.findeMemberMissionByMemeberId(memberId, PageRequest.of(page, size));
    }
}

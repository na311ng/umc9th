package com.example.umc9th.domain.mission.dto.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class MemberMissionChallengeResDTO {
    private Long memberMissionId;
    private Long missionId;
    private String message;
}

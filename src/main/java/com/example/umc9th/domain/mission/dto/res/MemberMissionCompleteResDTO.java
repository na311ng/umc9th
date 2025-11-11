package com.example.umc9th.domain.mission.dto.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class MemberMissionCompleteResDTO {
    private Long userMissionId;
    private String status;
    private String message;
}

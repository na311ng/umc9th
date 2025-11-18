package com.example.umc9th.domain.mission.dto.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberMissionChallengeReqDTO {
    @Builder.Default
    private boolean isComplete = false;
}

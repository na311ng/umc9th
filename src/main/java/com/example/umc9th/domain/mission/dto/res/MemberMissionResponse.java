package com.example.umc9th.domain.mission.dto.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
public class MemberMissionResponse {
    private Long memberMissionId;
    private Long missionId;
    private String storeName; // 가게 이름 추가
    private String conditional;
    private Integer point;
    private LocalDate duration;
    private boolean isComplete;
}

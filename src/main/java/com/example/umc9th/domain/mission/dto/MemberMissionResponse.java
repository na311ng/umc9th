package com.example.umc9th.domain.mission.dto;

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
    private Long storeName; // 가게 이름 추가
    private String conditional;
    private Integer point;
    private LocalDate duration;
    private boolean isComplete;
}

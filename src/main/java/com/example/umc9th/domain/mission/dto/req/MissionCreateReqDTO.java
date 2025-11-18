package com.example.umc9th.domain.mission.dto.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MissionCreateReqDTO {
    private String missionName;
    private String conditional;
    private Integer point;
    private LocalDate startDate;
    private LocalDate endDate;
}

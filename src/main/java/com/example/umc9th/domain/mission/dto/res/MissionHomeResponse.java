package com.example.umc9th.domain.mission.dto.res;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class MissionHomeResponse {
    private Long missionId;
    private String locationName;
    private String storeName;
    private String conditional;
    private Integer point;
    private LocalDate duration;
}

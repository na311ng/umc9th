package com.example.umc9th.domain.mission.dto.res;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MissionCreateResDTO {
    private Long missionId;
    private String storeName;
    private String duration;
    private String conditional;
    private Integer point;
}

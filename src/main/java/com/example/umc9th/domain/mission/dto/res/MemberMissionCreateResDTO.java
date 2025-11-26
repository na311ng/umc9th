package com.example.umc9th.domain.mission.dto.res;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberMissionCreateResDTO {
    private Long memberMissionId;
    private String memberName;
    private String storeName;
    private String conditional;
    private Integer point;
    private String duration;
    private Boolean isComplete;
}

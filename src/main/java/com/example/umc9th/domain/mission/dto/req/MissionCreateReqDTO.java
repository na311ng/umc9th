package com.example.umc9th.domain.mission.dto.req;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MissionCreateReqDTO {
    private String duration;
    private String conditional;
    private Integer point;
}

package com.example.umc9th.domain.store.dto.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StoreCreateReqDTO {
    private String name;
    private String address;
    private String bossNumber;
}

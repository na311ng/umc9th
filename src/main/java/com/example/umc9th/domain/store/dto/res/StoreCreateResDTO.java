package com.example.umc9th.domain.store.dto.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class StoreCreateResDTO {
    private Long storeId;
    private Long locationId;
    private String message;
}

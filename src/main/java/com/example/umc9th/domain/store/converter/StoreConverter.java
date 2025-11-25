package com.example.umc9th.domain.store.converter;

import com.example.umc9th.domain.store.dto.req.StoreCreateReqDTO;
import com.example.umc9th.domain.store.dto.res.StoreCreateResDTO;
import com.example.umc9th.domain.store.entitiy.Location;
import com.example.umc9th.domain.store.entitiy.Store;

public class StoreConverter {

    public static Store toEntity(StoreCreateReqDTO dto, Location location){
        return Store.builder()
                .name(dto.getName())
                .address(dto.getAddress())
                .bossNumber(dto.getBossNumber())
                .location(location)
                .build();
    }

    public static StoreCreateResDTO toCreateResDTO(Store store){
        return StoreCreateResDTO.builder()
                .storeId(store.getId())
                .locationId(store.getLocation().getId())
                .message("가게가 성공적으로 등록되었습니다.")
                .build();
    }
}

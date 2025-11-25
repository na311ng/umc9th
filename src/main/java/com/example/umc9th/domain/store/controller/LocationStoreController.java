package com.example.umc9th.domain.store.controller;

import com.example.umc9th.domain.store.dto.req.StoreCreateReqDTO;
import com.example.umc9th.domain.store.dto.res.StoreCreateResDTO;
import com.example.umc9th.domain.store.service.StoreCreateService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/locations")
public class LocationStoreController {

    private final StoreCreateService storeCreateService;

    @PostMapping("/{locationId}/stores")
    public ApiResponse<StoreCreateResDTO> createStore(
            @PathVariable Long locationId,
            @RequestBody StoreCreateReqDTO dto
    ){
        return ApiResponse.onSuccess(
                GeneralSuccessCode.CREATED,
                storeCreateService.createStore(locationId, dto)
        );
    }
}

package com.example.umc9th.domain.store.service;

import com.example.umc9th.domain.store.converter.StoreConverter;
import com.example.umc9th.domain.store.dto.req.StoreCreateReqDTO;
import com.example.umc9th.domain.store.dto.res.StoreCreateResDTO;
import com.example.umc9th.domain.store.entitiy.Location;
import com.example.umc9th.domain.store.entitiy.Store;
import com.example.umc9th.domain.store.repository.LocationRepository;
import com.example.umc9th.domain.store.repository.StoreRepository;
import com.example.umc9th.global.apiPayload.code.GeneralErrorCode;
import com.example.umc9th.global.apiPayload.exception.GeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StoreCreateService {

    private final StoreRepository storeRepository;
    private final LocationRepository locationRepository;

    @Transactional
    public StoreCreateResDTO createStore(Long locationId, StoreCreateReqDTO dto){
        Location location = locationRepository.findById(locationId)
                .orElseThrow(()->new GeneralException(GeneralErrorCode.NOT_FOUND));

        Store store = StoreConverter.toEntity(dto, location);
        Store saved = storeRepository.save(store);

        return StoreConverter.toCreateResDTO(saved);
    }

}

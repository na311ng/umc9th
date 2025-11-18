package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.review.dto.req.ReviewCreateReqDTO;
import com.example.umc9th.domain.review.dto.res.ReviewCreateResDTO;
import com.example.umc9th.domain.review.service.ReviewService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/stores")
public class StoreReviewController {
    private final ReviewService reviewService;
    // 리뷰 작성
    @PostMapping("/{storeId}/reviews")
    public ApiResponse<ReviewCreateResDTO> createReview(
            @PathVariable Long storeId,
            @RequestBody ReviewCreateReqDTO dto
    ){
        return ApiResponse.onSuccess(
                GeneralSuccessCode.CREATED,
                reviewService.createReview(storeId, dto)
        );
    }
}

package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.review.entitiy.Review;
import com.example.umc9th.domain.review.service.ReviewService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    // 리뷰 생성
    @PostMapping
    public ApiResponse<Review> createReview(@RequestBody Review review){
        Review createdreview = reviewService.createReview(review);
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, createdreview);
    }

    // 내 리뷰 조회
    @GetMapping("/my")
    public ApiResponse<List<Review>> searchReviews(
            @RequestParam(required = false) String locationName,
            @RequestParam(required = false) String storeName,
            @RequestParam(required = false) Integer starRange,
            @RequestParam Long memberId
    ){
        List<Review> reviews = reviewService.searchReviews(locationName, storeName, starRange, memberId);
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, reviews);
    }
}

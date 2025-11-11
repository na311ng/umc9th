package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.review.dto.req.ReviewCreateReqDTO;
import com.example.umc9th.domain.review.dto.res.ReviewCreateResDTO;
import com.example.umc9th.domain.review.entitiy.Review;
import com.example.umc9th.domain.review.service.ReviewService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping
    public Review createReview(@RequestBody Review review){
        return reviewService.createReview(review);
    }

    @GetMapping("/my")
    public List<Review> searchReviews(
            @RequestParam(required = false) String locationName,
            @RequestParam(required = false) String storeName,
            @RequestParam(required = false) Integer starRange,
            @RequestParam Long memberId
    ){
        return reviewService.searchReviews(locationName, storeName, starRange, memberId);
    }

    // 리뷰 작성
    @PostMapping
    public ApiResponse<ReviewCreateResDTO> createReview(
            @RequestBody ReviewCreateReqDTO request
    ) {
        return ApiResponse.onSuccess(
                GeneralSuccessCode.CREATED,
                reviewService.createReview(request)
        );
    }
}

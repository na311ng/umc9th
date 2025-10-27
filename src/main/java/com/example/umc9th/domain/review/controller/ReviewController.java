package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.review.entitiy.Review;
import com.example.umc9th.domain.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping
    public Review createReview(@RequestBody Review review){
        return reviewService.createReview(review);
    }
}

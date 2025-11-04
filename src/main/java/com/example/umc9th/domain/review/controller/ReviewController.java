package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.review.entitiy.Review;
import com.example.umc9th.domain.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping
    public Review createReview(@RequestBody Review review){
        return reviewService.createReview(review);
    }

    @GetMapping("/reviews/search")
    public List<Review> searchReviews(
            @RequestParam String query,
            @RequestParam String type){
        List<Review> result = reviewService.searchReview(query, type);
        return result;
    }
}

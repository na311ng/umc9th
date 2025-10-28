package com.example.umc9th.domain.review.service;

import com.example.umc9th.domain.review.entitiy.Review;
import com.example.umc9th.domain.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public Review createReview(Review review){
        return reviewRepository.save(review);
    }
}

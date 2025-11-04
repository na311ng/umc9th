package com.example.umc9th.domain.review.service;

import com.example.umc9th.domain.review.entitiy.QReview;
import com.example.umc9th.domain.review.entitiy.Review;
import com.example.umc9th.domain.review.repository.ReviewRepository;
import com.example.umc9th.domain.store.entitiy.QLocation;
import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public Review createReview(Review review){
        return reviewRepository.save(review);
    }

    public List<Review> searchReview(String query, String type){
        QReview review = QReview.review;
        QLocation location = QLocation.location;

        BooleanBuilder builder = new BooleanBuilder();

        if(type.equals("location")){
            builder.and(location.name.contains(query));
        }
        if(type.equals("star")){
            builder.and(review.star.goe(Float.parseFloat(query)));
        }
        if(type.equals("both")){
            String first = query.split("&")[0];
            String second = query.split("&")[1];

            builder.and(location.name.contains(first));
            builder.and(review.star.goe(Float.parseFloat(second)));
        }

        List<Review> reviewList = reviewRepository.searchReview(builder);

        return reviewList;
    }
}

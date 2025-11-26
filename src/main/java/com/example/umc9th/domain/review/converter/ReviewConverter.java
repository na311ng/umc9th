package com.example.umc9th.domain.review.converter;

import com.example.umc9th.domain.member.entitiy.Member;
import com.example.umc9th.domain.review.dto.req.ReviewCreateReqDTO;
import com.example.umc9th.domain.review.dto.res.ReviewCreateResDTO;
import com.example.umc9th.domain.review.entitiy.Review;
import com.example.umc9th.domain.store.entitiy.Store;

public class ReviewConverter {

    public static Review toEntity(ReviewCreateReqDTO dto, Member member, Store store){
        return Review.builder()
                .content(dto.getContent())
                .star(dto.getStar())
                .member(member)
                .store(store)
                .build();
    }

    public static ReviewCreateResDTO toResDTO(Review review){
        return ReviewCreateResDTO.builder()
                .reviewId(review.getId())
                .storeName(review.getStore().getName())
                .memberName(review.getMember().getName())
                .content(review.getContent())
                .star(review.getStar())
                .build();
    }
}

package com.example.umc9th.domain.review.dto.res;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReviewCreateResDTO {
    private Long reviewId;
    private String storeName;
    private String memberName;
    private String content;
    private Float star;
}

package com.example.umc9th.domain.review.dto.req;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewCreateReqDTO {
    private Long storeId;
    private Long memberId;
    private String content;
    private Float star;
}

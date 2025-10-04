package com.example.umc9th.domain.member.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FoodName {
    KOREAN("한식"),
    JAPANESE("일식"),
    CHINESE("중식"),
    WESTERN("양식"),
    CHICKEN("치킨"),
    BUNSIK("분식"),
    BBQ("고기/구이"),
    DOSIRAK("도시락"),
    LATE_NIGHT("야식"),
    FAST_FOOD("패스트푸드"),
    DESSERT("디저트"),
    ASIAN("아시안푸드");

    private final String koreanName;
}

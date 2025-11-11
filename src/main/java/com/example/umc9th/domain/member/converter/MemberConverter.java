package com.example.umc9th.domain.member.converter;

import com.example.umc9th.domain.member.dto.req.MemberReqDTO;
import com.example.umc9th.domain.member.dto.res.MemberResDTO;
import com.example.umc9th.domain.member.entitiy.Food;
import com.example.umc9th.domain.member.entitiy.Member;
import com.example.umc9th.domain.member.entitiy.mapping.MemberFood;
import com.example.umc9th.domain.member.enums.Gender;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class MemberConverter {
    // DTO -> Entity (회원가입 시)
    public static Member toEntity(MemberReqDTO dto) {
        return Member.builder()
                .name(dto.getName())
                .gender(Gender.valueOf(dto.getGender().toUpperCase()))
                .birthday(LocalDate.parse(dto.getBirthday()))
                .address(dto.getAddress())
                .detailAddress(dto.getDetailAddress())
                .build();
    }

    // Food 리스트 -> MemberFood 리스트 매핑
    public static List<MemberFood> toMemeberFoods (Member member, List<Food> foods) {
        return foods.stream()
                .map(food -> MemberFood.builder()
                        .member(member)
                        .food(food)
                        .build())
                .collect(Collectors.toList());
    }

    // Entity -> DTO
    public static MemberResDTO toResDTO(Member member, List<MemberFood> memberFoods) {
        List<String> foodNames = memberFoods.stream()
                .map(memberFood -> memberFood.getFood().getName().getKoreanName())
                .collect(Collectors.toList());

        return MemberResDTO.builder()
                .name(member.getName())
                .gender(member.getGender().name())
                .birthday(member.getBirthday().toString())
                .address(member.getAddress())
                .detailAddress(member.getDetailAddress())
                .userFood(foodNames)
                .build();
    }
}

package com.example.umc9th.domain.member.service;

import com.example.umc9th.domain.member.converter.MemberConverter;
import com.example.umc9th.domain.member.dto.req.MemberReqDTO;
import com.example.umc9th.domain.member.dto.res.MemberResDTO;
import com.example.umc9th.domain.member.entitiy.Food;
import com.example.umc9th.domain.member.entitiy.Member;
import com.example.umc9th.domain.member.entitiy.mapping.MemberFood;
import com.example.umc9th.domain.member.enums.FoodName;
import com.example.umc9th.domain.member.repository.FoodRepository;
import com.example.umc9th.domain.member.repository.MemberFoodRepository;
import com.example.umc9th.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;
    private final FoodRepository foodRepository;
    private final MemberFoodRepository memberFoodRepository;

    public Optional<Member> getMemberProfile(Long id){
        return memberRepository.findById(id);
    }

    public MemberResDTO createMember(MemberReqDTO memberReqDTO){

        Member member = MemberConverter.toEntity(memberReqDTO);
        memberRepository.save(member);

        List<Food> foods = memberReqDTO.getUserFood().stream()
                .map(food -> foodRepository.findByName(FoodName.valueOf(food.toUpperCase()))
                        .orElseThrow(()->new IllegalArgumentException("Invalid food name: "+ food)))
                .collect(Collectors.toList());

        List<MemberFood> memberFoods = MemberConverter.toMemeberFoods(member, foods);
        memberFoodRepository.saveAll(memberFoods);

        return MemberConverter.toResDTO(member, memberFoods);
    }
}

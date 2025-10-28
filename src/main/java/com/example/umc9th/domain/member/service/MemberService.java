package com.example.umc9th.domain.member.service;

import com.example.umc9th.domain.member.entitiy.Member;
import com.example.umc9th.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Optional<Member> getMemberProfile(Long id){
        return memberRepository.findById(id);
    }
}

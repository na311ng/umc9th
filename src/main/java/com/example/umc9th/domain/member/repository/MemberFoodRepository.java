package com.example.umc9th.domain.member.repository;

import com.example.umc9th.domain.member.entitiy.Member;
import com.example.umc9th.domain.member.entitiy.mapping.MemberFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberFoodRepository extends JpaRepository<MemberFood,Long> {
    List<MemberFood> findByMember(Member member);
}

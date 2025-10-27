package com.example.umc9th.domain.member.repository;

import com.example.umc9th.domain.member.entitiy.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
    // 특정 사용자 정보 조회
    Optional<Member> findById(Long id);

    // 이메일로 사용자 찾기
    Optional<Member> findByEmail(String email);
}

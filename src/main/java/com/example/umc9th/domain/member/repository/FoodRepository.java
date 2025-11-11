package com.example.umc9th.domain.member.repository;

import com.example.umc9th.domain.member.entitiy.Food;
import com.example.umc9th.domain.member.enums.FoodName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FoodRepository extends JpaRepository<Food,Long> {
    Optional<Food> findByName(FoodName name);
}

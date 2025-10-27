package com.example.umc9th.domain.review.repository;

import com.example.umc9th.domain.review.entitiy.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}

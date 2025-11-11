package com.example.umc9th.domain.review.repository;

import com.example.umc9th.domain.review.entitiy.QReview;
import com.example.umc9th.domain.review.entitiy.Review;
import com.example.umc9th.domain.store.entitiy.QLocation;
import com.example.umc9th.domain.store.entitiy.QStore;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewQueryDslImpl implements ReviewQueryDsl{
    private final EntityManager em;

    // 검색 API
    @Override
    public List<Review> searchReviews(BooleanBuilder builder){
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        QReview review = QReview.review;
        QStore store = QStore.store;
        QLocation location = QLocation.location;

        return queryFactory
                .selectFrom(review)
                .leftJoin(review.store, store).fetchJoin()
                .leftJoin(store.location, location)
                .where(builder)
                .orderBy(review.createdAt.desc())
                .fetch();
    };
}

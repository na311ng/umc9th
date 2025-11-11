package com.example.umc9th.domain.store.repository;

import com.example.umc9th.domain.store.entitiy.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}

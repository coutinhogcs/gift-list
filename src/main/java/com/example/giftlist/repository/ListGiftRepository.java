package com.example.giftlist.repository;

import com.example.giftlist.entity.ListGift;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListGiftRepository extends JpaRepository<ListGift, Long> {
}

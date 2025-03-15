package com.example.giftlist.repository;

import com.example.giftlist.domain.ListGift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListGiftRepository extends JpaRepository<ListGift, Long> {
}

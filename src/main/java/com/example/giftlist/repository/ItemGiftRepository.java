package com.example.giftlist.repository;

import com.example.giftlist.domain.ItemGift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemGiftRepository extends JpaRepository<ItemGift, Long> {
}

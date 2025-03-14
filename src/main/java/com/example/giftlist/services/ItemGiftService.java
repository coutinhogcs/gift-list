package com.example.giftlist.services;

import com.example.giftlist.entity.ItemGift;
import com.example.giftlist.entity.ListGift;
import com.example.giftlist.repository.ItemGiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemGiftService {

    @Autowired
    ItemGiftRepository itemGiftRepository;

    public ItemGift createItem(ItemGift itemGift) {
        return itemGiftRepository.save(itemGift);
    }

    public List<ItemGift> findAll() {
        return itemGiftRepository.findAll();
    }

    public Optional<ItemGift> findItemById(Long id) {
        return itemGiftRepository.findById(id);
    }

    public ItemGift updateItem(Long id, ItemGift updatedItem) {
        Optional<ItemGift> item = findItemById(id);
        updatedItem.setId(id);
        return itemGiftRepository.save(updatedItem);
    }

    public void deleteItem(Long id){
        itemGiftRepository.deleteById(id);
    }
}

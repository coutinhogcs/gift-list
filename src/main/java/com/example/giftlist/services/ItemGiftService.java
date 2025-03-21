package com.example.giftlist.services;

import com.example.giftlist.domain.ItemGift;
import com.example.giftlist.domain.ListGift;
import com.example.giftlist.domain.User;
import com.example.giftlist.repository.ItemGiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemGiftService {

    @Autowired
    ItemGiftRepository itemGiftRepository;
    @Autowired
    ListGiftService listGiftService;
    @Autowired
    UserService userService;

    public ItemGift createItem(Long listId, Long userId, ItemGift itemGift) {
        User findUser = userService.findUserById(userId);
        ListGift findList = listGiftService.findListById(listId);
        itemGift.setPurchasedBy(findUser);
        itemGift.setListId(findList);
        return itemGiftRepository.save(itemGift);
    }

    public List<ItemGift> findAll() {
        return itemGiftRepository.findAll();
    }

    public Optional<ItemGift> findItemById(Long id) {
        return itemGiftRepository.findById(id);
    }

    public ItemGift updateItem(Long itemId, Long listId, Long userId, ItemGift updatedItem) {
        ListGift existList = listGiftService.findListById(listId);
        User existUser = userService.findUserById(userId);
        updatedItem.setId(itemId);
        updatedItem.setListId(existList);
        updatedItem.setPurchasedBy(existUser);
        return itemGiftRepository.save(updatedItem);
    }

    public void deleteItem(Long id){
        itemGiftRepository.deleteById(id);
    }
}

package com.example.giftlist.controller;

import com.example.giftlist.domain.ItemGift;
import com.example.giftlist.domain.ListGift;
import com.example.giftlist.domain.User;
import com.example.giftlist.services.ItemGiftService;
import com.example.giftlist.services.ListGiftService;
import com.example.giftlist.services.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/item")
public class ItemGiftController {
    @Autowired
    private ItemGiftService itemGiftService;

    @Autowired
    private ListGiftService listGiftService;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<ItemGift> findAll() {
        return itemGiftService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<ItemGift> findById(@PathVariable Long id) {
        return itemGiftService.findItemById(id);
    }

    @PostMapping("/{listId}/{purchasedByUserId}")
    @Transactional
    public ItemGift createItem(@PathVariable Long listId, @PathVariable Long purchasedByUserId, @RequestBody ItemGift itemGift) {
        ListGift list = listGiftService.findListById(listId)
                .orElseThrow(() -> new RuntimeException("Erro"));
        User userList = userService.findUserById(purchasedByUserId);
        itemGift.setListId(list);
        itemGift.setPurchasedBy(userList);

        return itemGiftService.createItem(itemGift);
    }

    @PutMapping("/{itemId}/{listId}/{purchasedByUserId}")
    @Transactional
    public ItemGift updateItem(@PathVariable Long itemId, @PathVariable Long listId, @PathVariable Long purchasedByUserId, @RequestBody ItemGift updatedItem) {
        return itemGiftService.updateItem(itemId, listId, purchasedByUserId, updatedItem);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteItem(@PathVariable Long id) {
        itemGiftService.deleteItem(id);
    }

}

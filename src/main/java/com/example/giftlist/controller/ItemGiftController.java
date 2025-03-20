package com.example.giftlist.controller;

import com.example.giftlist.domain.ItemGift;
import com.example.giftlist.domain.ListGift;
import com.example.giftlist.domain.User;
import com.example.giftlist.services.ItemGiftService;
import com.example.giftlist.services.ListGiftService;
import com.example.giftlist.services.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<ItemGift>> findAll() {
        List<ItemGift> itemGiftList = itemGiftService.findAll();
        if(itemGiftList.isEmpty()){
            return new ResponseEntity<>(itemGiftList, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(itemGiftList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Optional<ItemGift> findById(@PathVariable Long id) {
        return itemGiftService.findItemById(id);
    }

    @PostMapping("/{listId}/{purchasedByUserId}")
    @Transactional
    public ResponseEntity<ItemGift>  createItem(@PathVariable Long listId, @PathVariable Long purchasedByUserId, @RequestBody ItemGift itemGift) {
        ItemGift createItem = itemGiftService.createItem(listId, purchasedByUserId, itemGift);
        return new ResponseEntity<>(createItem, HttpStatus.CREATED);
    }

    @PutMapping("/{itemId}/{listId}/{purchasedByUserId}")
    @Transactional
    public ResponseEntity<ItemGift> updateItem(@PathVariable Long itemId, @PathVariable Long listId, @PathVariable Long purchasedByUserId, @RequestBody ItemGift updatedItem) {
         ItemGift updateItem = itemGiftService.updateItem(itemId, listId, purchasedByUserId, updatedItem);
        return new ResponseEntity<>(updateItem, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        itemGiftService.deleteItem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

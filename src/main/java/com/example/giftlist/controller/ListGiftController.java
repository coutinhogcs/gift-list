package com.example.giftlist.controller;

import com.example.giftlist.entity.ListGift;
import com.example.giftlist.entity.User;
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
@RequestMapping("/list")
public class ListGiftController {

    @Autowired
    ListGiftService listGiftService;

    @Autowired
    UserService userService;

    @GetMapping
    public List<ListGift> findAll(){
        return  listGiftService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<ListGift> findListById(@PathVariable Long id){
        return listGiftService.findListById(id);
    }


    @PostMapping("/{userId}")
    public ResponseEntity<ListGift> createList(@PathVariable Long userId, @RequestBody ListGift listGift) {
        User user = userService.findUserById(userId);
        if (user == null){
            return ResponseEntity.notFound().build();
        }
        listGift.setUser(user);
        ListGift createdList = listGiftService.createList(listGift);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdList);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ListGift> updateList(@PathVariable Long id, @RequestBody ListGift updatedList) {
        ListGift updated = listGiftService.updateList(id, updatedList);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    @Transactional
    public void deleteList(Long id){
        listGiftService.deleteList(id);
    }
}

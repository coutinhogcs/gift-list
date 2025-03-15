package com.example.giftlist.controller;

import com.example.giftlist.domain.ListGift;
import com.example.giftlist.domain.User;
import com.example.giftlist.services.ListGiftService;
import com.example.giftlist.services.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ListGift createList(@PathVariable Long userId, @RequestBody ListGift listGift) {
        User user = userService.findUserById(userId);
        listGift.setUser(user);
        return listGiftService.createList(listGift);
    }

    @PutMapping("/{id}")
    @Transactional
    public ListGift updateList(@PathVariable Long id, @RequestBody ListGift updatedList) {
        return listGiftService.updateList(id, updatedList);
    }


    @DeleteMapping("/{id}")
    @Transactional
    public void deleteList(Long id){
        listGiftService.deleteList(id);
    }
}

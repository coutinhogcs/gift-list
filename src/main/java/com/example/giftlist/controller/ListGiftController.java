package com.example.giftlist.controller;

import com.example.giftlist.domain.ListGift;
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
   private ListGiftService listGiftService;

    @Autowired
   private UserService userService;

    @GetMapping
    public ResponseEntity<List<ListGift>> findAll(){
        List<ListGift> list =  listGiftService.findAll();
        if(list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ListGift findListById(@PathVariable Long id){
        return listGiftService.findListById(id);
    }

    public ResponseEntity<ListGift> createList(@PathVariable Long userId, @RequestBody ListGift listGift) {
        ListGift createList = listGiftService.createList(userId, listGift);
         return new ResponseEntity<>(createList, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ListGift>  updateList(@PathVariable Long id, @RequestBody ListGift updatedList) {
        ListGift updateList = listGiftService.updateList(id, updatedList);
        return new ResponseEntity<>(updatedList, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deleteList(Long id){
         listGiftService.deleteList(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

package com.example.giftlist.controller;

import com.example.giftlist.entity.User;
import com.example.giftlist.services.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id){
        return userService.findUserById(id);
    }

    @PostMapping
    @Transactional
    public User create(@RequestBody User user){
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        return  userService.createUser(user);
    }
    @PutMapping("/{id}")
    public List<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        User userExist = userService.findUserById(id);
        if(userExist == null){
            return null;
        }
        user.setId(id);
        User updatedUser = userService.updateUser(user);
        return Arrays.asList(updatedUser);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        userService.deleteById(id);
    }
}

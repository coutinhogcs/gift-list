package com.example.giftlist.services;

import com.example.giftlist.entity.User;
import com.example.giftlist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null);
    }
    public User createUser(User user){
        return userRepository.save(user);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User updateUser(Long id, User user){
        User existUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Não existe usuário com esse ID"));
        user.setId(id);
        return userRepository.save(user);
    }

    public void deleteById(Long id){
         userRepository.deleteById(id);
    }
}

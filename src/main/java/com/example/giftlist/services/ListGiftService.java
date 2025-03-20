package com.example.giftlist.services;

import com.example.giftlist.domain.ListGift;
import com.example.giftlist.domain.User;
import com.example.giftlist.repository.ListGiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListGiftService {

    @Autowired
    private ListGiftRepository listRepository;

    @Autowired
    private UserService userService;

    public ListGift createList(Long id, ListGift list){
        User findUser = userService.findUserById(id);
        list.setUser(findUser);
        return listRepository.save(list);
    }

    public ListGift findListById(Long id){
        Optional<ListGift> listGiftOptional = listRepository.findById(id);
        return listGiftOptional.orElseThrow(() -> new RuntimeException("Não existe lista com este id: " + id));
    }

    public List<ListGift> findAll(){
        return listRepository.findAll();
    }

    public ListGift updateList(Long id, ListGift updatedList){
        ListGift listGift = findListById(id);
        updatedList.setId(id);
        return listRepository.save(updatedList);
    }

    public void deleteList(Long id){
    }
}

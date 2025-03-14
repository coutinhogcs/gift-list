package com.example.giftlist.services;

import com.example.giftlist.entity.ListGift;
import com.example.giftlist.repository.ListGiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListGiftService {
    @Autowired
    ListGiftRepository listRepository;

    public ListGift createList(ListGift list){
        return listRepository.save(list);
    }
    public Optional<ListGift> findListById(Long id){
        return listRepository.findById(id);
    }
    public List<ListGift> findAll(){
        return listRepository.findAll();
    }

    public ListGift updateList(Long id, ListGift updatedList){
        Optional<ListGift> listGift = findListById(id);
        updatedList.setId(id);
        return listRepository.save(updatedList);
    }

    public void deleteList(Long id){
        listRepository.deleteById(id);
    }
}

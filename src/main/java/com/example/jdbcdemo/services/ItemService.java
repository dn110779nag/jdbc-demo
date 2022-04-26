package com.example.jdbcdemo.services;

import com.example.jdbcdemo.domain.Item;
import com.example.jdbcdemo.repos.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    @Transactional(rollbackFor = Exception.class)
    public Item create(String name, String description) throws Exception {
        Item item = itemRepository.create3(name, description);
        if(name.equals("ERROR")){
            throw new Exception("rollback");
        }
        return item;
    }
}

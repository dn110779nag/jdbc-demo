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

    @Transactional
    public Item create(String name, String description) throws Exception {
        Item item = itemRepository.save(Item.builder()
                        .name(name)
                        .description(description)
                .build());
        if(name.equals("ERROR")){
            throw new RuntimeException("rollback");
        }
        return item;
    }
}

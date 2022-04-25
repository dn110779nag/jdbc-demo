package com.example.jdbcdemo.services;


import com.example.jdbcdemo.TCSupport;
import com.example.jdbcdemo.repos.ItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ItemServiceTest extends TCSupport {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemService itemService;

    @Test
    void create() {
        try {
            itemService.create("ERROR", "error");
        } catch (Exception e) {
            System.out.println("Error as expected");
        }

        assertThat(itemRepository.findAll()).isEmpty();
    }
}
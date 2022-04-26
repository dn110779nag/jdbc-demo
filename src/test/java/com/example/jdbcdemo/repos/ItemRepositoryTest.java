
package com.example.jdbcdemo.repos;

import com.example.jdbcdemo.TCSupport;
import com.example.jdbcdemo.domain.Item;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ItemRepositoryTest extends TCSupport {
    
    @Autowired
    private ItemRepository instance;
    

    @BeforeEach
    @AfterEach
    void clear(){
        instance.deleteAll();
    }
    


    @Test
    public void testCreate(){
        Item saved = instance.save(Item.builder()
                .name("test")
                .description("very long description")
                .build());
        Optional<Item> result = instance.findById(saved.getId());
        assertThat(result).isPresent().hasValueSatisfying(
                e -> assertThat(e.getName()).isEqualTo("test")
        );
    }


}

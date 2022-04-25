
package com.example.jdbcdemo.repos;

import com.example.jdbcdemo.TCSupport;
import com.example.jdbcdemo.domain.Item;
import java.sql.SQLException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest(properties = {
    "spring.datasource.url=jdbc:tc:postgresql:14:///test_database",
    "spring.datasource.username=foo",
    "spring.datasource.password=secret"
})
public class ItemRepositoryTest extends TCSupport {
    
    @Autowired
    private ItemRepository instance;
    

    @BeforeEach
    @AfterEach
    void clear(){
        instance.deleteAll();
    }
    


    @Test
    public void testCreate() throws SQLException {
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

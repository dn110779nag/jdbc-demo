
package com.example.jdbcdemo.repos;

import com.example.jdbcdemo.TCSupport;
import com.example.jdbcdemo.domain.Item;
import java.sql.SQLException;
import static org.assertj.core.api.Assertions.assertThat;

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
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    @AfterEach
    void clear(){
        jdbcTemplate.update("truncate table items");
    }
    


    @Test
    public void testCreate() throws SQLException {
        instance.create("test", "very long description");
        String result = jdbcTemplate.queryForObject("select name from items", String.class);
        assertThat(result).isEqualTo("test");
    }
    
    @Test
    public void testCreate2() throws SQLException {
        Item item = instance.create2("test", "very long description");
        String result = jdbcTemplate.queryForObject("select name from items", String.class);
        assertThat(item.getId()).isPositive();
        assertThat(result).isEqualTo("test");
    }

    @Test
    public void testCreate3() throws SQLException {
        Item item = instance.create3("test", "very long description");
        String result = jdbcTemplate.queryForObject("select name from items", String.class);
        assertThat(item.getId()).isPositive();
        assertThat(result).isEqualTo("test");
    }


    @Test
    public void testFindById() throws SQLException {
        Item item = instance.create3("test", "very long description");

        assertThat(item.getId()).isPositive();

        Item result = instance.findBiId(item.getId());
        assertThat(result).isEqualTo(item);
    }

}

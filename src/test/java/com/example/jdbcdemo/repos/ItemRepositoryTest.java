/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.example.jdbcdemo.repos;

import com.example.jdbcdemo.domain.Item;
import java.sql.SQLException;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

/**
 *
 * @author dn110
 */
@Testcontainers
@SpringBootTest(properties = {
    "spring.datasource.url=jdbc:tc:postgresql:14:///test_database",
    "spring.datasource.username=foo",
    "spring.datasource.password=secret"
})
public class ItemRepositoryTest {
    
    @Autowired
    private ItemRepository instance;
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    @AfterEach
    void clear(){
        jdbcTemplate.update("truncate table items");
    }
    

    @Container
    private PostgreSQLContainer postgresqlContainer = new PostgreSQLContainer(DockerImageName.parse("postgres"))
            .withDatabaseName("test_database")
            .withUsername("foo")
            .withPassword("secret");

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

}

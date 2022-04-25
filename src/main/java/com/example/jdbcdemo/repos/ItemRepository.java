/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.jdbcdemo.repos;

import com.example.jdbcdemo.domain.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dn110
 */
@Repository
@Slf4j
public class ItemRepository {
    private final JdbcTemplate jdbcTemplate;

    private final SimpleJdbcInsert itemInsert;

    public ItemRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        itemInsert = new SimpleJdbcInsert(jdbcTemplate.getDataSource())
                .withTableName("items")
                .usingGeneratedKeyColumns("id");
    }

    public Item create(String name, String description){
        jdbcTemplate.update("insert into items(name, description) values(?,?)", name, description);
        return Item.builder()
                .name(name)
                .description(description)
                .build();
    }
    
    public Item create2(String name, String description){
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update((Connection con) -> {
            PreparedStatement ps = con.prepareStatement(
                    "insert into items(name, description) values(?,?)"
                    , new String[]{"id"}
            );
            ps.setString(1, name);
            ps.setString(2, description);
            return ps;
        }, generatedKeyHolder);
        
      log.debug("key ==> {}", generatedKeyHolder.getKey());
        return Item.builder()
                .name(name)
                .description(description)
                .id(Objects.requireNonNull(generatedKeyHolder.getKey()).longValue())
                .build();
    }


    public Item create3(String name, String description){

        long id = itemInsert.executeAndReturnKey(Map.of(
                "name", name,
                "description", description
        )).longValue();
        return Item.builder()
                .name(name)
                .description(description)
                .id(id)
                .build();
    }
}

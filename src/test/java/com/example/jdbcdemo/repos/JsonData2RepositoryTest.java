package com.example.jdbcdemo.repos;

import com.example.jdbcdemo.TCSupport;
import com.example.jdbcdemo.domain.JsonData;
import com.example.jdbcdemo.domain.JsonData2;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class JsonData2RepositoryTest extends TCSupport {
    @Autowired
    private JsonData2Repository instance;

    @BeforeEach
    @AfterEach
    void clear() {
        instance.deleteAll();
    }

    @Test
    @Disabled
    void testSave() throws JsonProcessingException {

        JsonData2 saved = instance.save(JsonData2.builder().val1(Map.of("k1", "v1")).build());
        System.out.println("start find");
        Optional<JsonData2> result = instance.findById(saved.getId());

        assertThat(result).isPresent().hasValueSatisfying(e -> {
            assertThat(e.getVal1()).isNotNull();
//            assertThat(e.getVal1().get("k1").asText()).isEqualTo("v1");

        });

        System.out.println("result ==> " + result);


    }
}
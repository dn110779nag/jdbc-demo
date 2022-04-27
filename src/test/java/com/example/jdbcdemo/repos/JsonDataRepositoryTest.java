package com.example.jdbcdemo.repos;

import com.example.jdbcdemo.TCSupport;
import com.example.jdbcdemo.domain.JsonData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JsonDataRepositoryTest extends TCSupport {
    @Autowired
    private JsonDataRepository instance;

    @BeforeEach
    @AfterEach
    void clear() {
        instance.deleteAll();
    }

    @Test
    void testSave() throws JsonProcessingException {
        JsonNode node = new ObjectMapper().readValue("{\"k1\":\"v1\"}", JsonNode.class);
        JsonData saved = instance.save(JsonData.builder().val1(node).build());

        Optional<JsonData> result = instance.findById(saved.getId());

        assertThat(result).isPresent().hasValueSatisfying(e -> {
            assertThat(e.getVal1()).isNotNull();
//            assertThat(e.getVal1().get("k1").asText()).isEqualTo("v1");

        });


    }
}
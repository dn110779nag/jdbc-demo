package com.example.jdbcdemo.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.convert.ReadingConverter;

@Slf4j
@ReadingConverter
public class PgObjectToJsonNodeConverter extends PgObjectToDetailsConverter<JsonNode> {

    public PgObjectToJsonNodeConverter(ObjectMapper objectMapper) {
        super(JsonNode.class, objectMapper);
    }
}

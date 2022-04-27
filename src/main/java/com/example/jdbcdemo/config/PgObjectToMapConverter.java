package com.example.jdbcdemo.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.convert.ReadingConverter;

import java.util.Map;

@Slf4j
@ReadingConverter
public class PgObjectToMapConverter extends PgObjectToDetailsConverter<Map<String, Object>> {

    public PgObjectToMapConverter(ObjectMapper objectMapper) {
        super(new TypeReference<>() {}, objectMapper);
    }
}

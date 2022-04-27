package com.example.jdbcdemo.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.convert.WritingConverter;

@WritingConverter
public class JsonNodeToPgObjectConverter
        extends DetailsToPgObjectConverter<JsonNode> {

    public JsonNodeToPgObjectConverter(ObjectMapper objectMapper) {
        super(objectMapper);
    }
}

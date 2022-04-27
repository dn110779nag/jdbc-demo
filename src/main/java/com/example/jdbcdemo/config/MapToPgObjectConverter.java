package com.example.jdbcdemo.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.convert.WritingConverter;

import java.util.Map;

@WritingConverter
public class MapToPgObjectConverter
        extends DetailsToPgObjectConverter<Map> {

    public MapToPgObjectConverter(ObjectMapper objectMapper) {
        super(objectMapper);
    }
}

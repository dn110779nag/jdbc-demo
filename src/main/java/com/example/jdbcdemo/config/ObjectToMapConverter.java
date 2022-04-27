package com.example.jdbcdemo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

import java.util.Map;

@Slf4j
@ReadingConverter
public class ObjectToMapConverter implements Converter<Object, Map<String, Object>> {
    @Override
    public Map<String, Object> convert(Object source) {
        log.info("source ==> {}", source);
        return Map.of("v", source);
    }
}

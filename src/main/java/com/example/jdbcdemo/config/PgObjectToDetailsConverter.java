package com.example.jdbcdemo.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.postgresql.util.PGobject;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

@Slf4j
@ReadingConverter
@RequiredArgsConstructor
public class PgObjectToDetailsConverter<T> implements Converter<PGobject, T> {

    private final TypeReference<T> TYPE;
    private final ObjectMapper objectMapper;

    @Override
    public T convert(PGobject pGobject) {
        try {
            return objectMapper.readValue(pGobject.getValue(), TYPE);
        } catch (JsonProcessingException e) {
            log.warn("JSON deserialization to " + TYPE.getType().getTypeName() + " failed.", e);
        }
        return null;
    }
}
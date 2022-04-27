package com.example.jdbcdemo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.postgresql.util.PGobject;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

@Slf4j
@WritingConverter
@RequiredArgsConstructor
public class DetailsToPgObjectConverter<T> implements Converter<T, PGobject> {

    private static final String JSON_TYPE = "json";
    private final ObjectMapper objectMapper;

    @Override
    public PGobject convert(T details) {
        PGobject pGobject = new PGobject();
        pGobject.setType(JSON_TYPE);
        try {
            pGobject.setValue(objectMapper.writeValueAsString(details));
        } catch (Exception e) {
            log.error("ClientStateDetails deserialization failed.", e);
            throw new RuntimeException(e);
        }
        return pGobject;
    }

}

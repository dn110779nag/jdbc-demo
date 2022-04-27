package com.example.jdbcdemo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;

import java.util.List;

@Configuration
@AllArgsConstructor
public class MyJdbcConfiguration extends AbstractJdbcConfiguration {

    private final ObjectMapper objectMapper;

    @Override
    protected List<?> userConverters() {
        return List.of(
                new JsonNodeToPgObjectConverter(objectMapper),
                new PgObjectToJsonNodeConverter(objectMapper),
                new MapToPgObjectConverter(objectMapper),
                new PgObjectToMapConverter(objectMapper),
                new ObjectToMapConverter()
        );
    }
}

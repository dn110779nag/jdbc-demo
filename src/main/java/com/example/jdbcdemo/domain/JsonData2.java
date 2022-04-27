package com.example.jdbcdemo.domain;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Map;

@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Builder
@Table("json_data2")
public class JsonData2 {
    @Id
    private Long id;
    private Map<String, Object> val1;
}

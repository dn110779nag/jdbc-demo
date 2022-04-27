package com.example.jdbcdemo.domain;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Builder
@Table("json_data")
public class JsonData {
    @Id
    private Long id;
    private JsonNode val1;
}

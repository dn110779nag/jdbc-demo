package com.example.jdbcdemo.repos;

import com.example.jdbcdemo.domain.JsonData;
import org.springframework.data.repository.CrudRepository;

public interface JsonDataRepository extends CrudRepository<JsonData, Long> {

}

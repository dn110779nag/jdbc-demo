package com.example.jdbcdemo;

import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@Testcontainers
public class TCSupport {
    @Container
    private PostgreSQLContainer postgresqlContainer = new PostgreSQLContainer(DockerImageName.parse("postgres"))
            .withDatabaseName("test_database")
            .withUsername("foo")
            .withPassword("secret");

}

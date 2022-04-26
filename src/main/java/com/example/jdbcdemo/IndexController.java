package com.example.jdbcdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
public class IndexController {

    @lombok.Value
    @lombok.Builder
    public static class HelloResponse{
        String greeting;
        Instant time;
    }

    @GetMapping("/api/say/hello")
    public HelloResponse sayHello(@RequestParam("name") String name){
        return HelloResponse.builder()
                .greeting("Hello, " + name)
                .time(Instant.now())
                .build();
    }
}

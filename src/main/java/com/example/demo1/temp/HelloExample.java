package com.example.demo1.temp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloExample {

    @GetMapping
    public String hello() {
        return "hello world!";
    }
}

package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldService {

    @RequestMapping("/hello")
    public String sayHello() {
        return "hello world";
    }


}

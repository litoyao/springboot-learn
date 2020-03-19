package com.example.demo.controller;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserServiceController {

    @Autowired
    UserService userService;

    @RequestMapping("/hi")
    public String sayHi(@RequestParam String name){
        return  userService.sayHi(name);
    }

}

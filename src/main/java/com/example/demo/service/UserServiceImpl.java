package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public String sayHi(String name) {
        logger.info("in UserServiceImpl. Hi,"+name);
        return "Hi,"+name;
    }
}

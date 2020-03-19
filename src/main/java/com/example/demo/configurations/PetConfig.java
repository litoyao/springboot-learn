package com.example.demo.configurations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PetConfig {

    Logger logger = LoggerFactory.getLogger(PetConfig.class);

//    @Value("${pets}")
//    String[] pets;

    @Value("${server.port}")
    private int port;

//    public String[] getPets() {
//        return pets;
//    }
//
//    public void setPets(String[] pets) {
//        this.pets = pets;
//    }

    public void show() {
        logger.info("server.port:" + port);

    }
}

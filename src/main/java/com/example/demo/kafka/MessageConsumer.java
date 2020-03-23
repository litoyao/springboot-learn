package com.example.demo.kafka;

import org.springframework.beans.factory.annotation.Autowired;

public class MessageConsumer {


    @Autowired
    EsService esService;

    /**
     *  read message from kafka, write to ES
     */
    public void readMessageFromKafkaAndWriteToES(){
        Message message =null;      //from kafka
        esService.writeToElasticSearch(message);

    }
}

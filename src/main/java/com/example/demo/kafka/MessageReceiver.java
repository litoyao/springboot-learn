package com.example.demo.kafka;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageReceiver {

    /**
     *  接到消息之后
     * @param message
     */
    @RequestMapping("/data-send")
    public void writeMessageToKafkaCluster(Message message){}
}

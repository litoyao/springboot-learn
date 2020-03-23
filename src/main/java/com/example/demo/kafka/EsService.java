package com.example.demo.kafka;

import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class EsService {

    /**
     * 写到 elastic-search
     *
     * @param message
     */
    public void writeToElasticSearch(Message message) {
    }

    /**
     *  从elasticsearch中检索
     * @param start
     * @param end
     * @return
     */
    public List<Message> searchMessageBetween(Date start, Date end, int rowNumber,int count) {
        return null;
    }
}

package com.spliff.virtualmenu.config.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @KafkaListener(topics = "orders", groupId = "group_id")
    public void consume(String message) {
        System.out.println(message);
    }
}
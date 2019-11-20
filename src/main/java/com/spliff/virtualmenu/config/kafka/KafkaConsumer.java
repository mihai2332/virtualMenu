package com.spliff.virtualmenu.config.kafka;

import com.spliff.virtualmenu.entity.Order;
import com.spliff.virtualmenu.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @Autowired
    SimpMessagingTemplate webSocket;
    @Autowired
    OrderRepo orderRepo;

    @KafkaListener(topics = "orders", groupId = "group_id")
    public void consume(String message) {
        Order order = orderRepo.findByUuid(message).orElseThrow(() -> new IllegalArgumentException("Order not found"));
        webSocket.convertAndSend("/topic/orders", order);
    }
}
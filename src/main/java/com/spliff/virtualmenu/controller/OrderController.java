package com.spliff.virtualmenu.controller;

import com.spliff.virtualmenu.entity.Order;
import com.spliff.virtualmenu.entity.dto.OrderDTO;
import com.spliff.virtualmenu.service.OrderingTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@RequestMapping(value = "/order")
@Controller
public class OrderController {
    private Logger logger = LoggerFactory.getLogger(OrderController.class);
    @Autowired
    OrderingTableService tableService;

    @PostMapping
    public ResponseEntity addOrder(@RequestBody OrderDTO orderDTO) {
        tableService.addOrder(orderDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity getWFA_Orders() {
        Set<Order> orders = tableService.getWFA_Orders();
        return ResponseEntity.ok(orders);
    }

    @MessageMapping("/app/subscribe")
    @SendTo("/topic/orders")
    public void connectWebSocket() {
        logger.info("WebSocket connected!");
    }
}
package com.spliff.Virtualmenu.controller;

import com.spliff.Virtualmenu.entity.Order;
import com.spliff.Virtualmenu.entity.Restaurant;
import com.spliff.Virtualmenu.entity.dto.OrderDTO;
import com.spliff.Virtualmenu.repository.RestaurantRepo;
import com.spliff.Virtualmenu.service.OrderingTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
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

    @GetMapping("/{restaurantUUID}")
    public ResponseEntity getWFA_OrdersByRestaurant(@PathVariable String restaurantUUID) {
        Set<Order> orders = tableService.getWFA_OrdersByRestaurant(restaurantUUID);
        return ResponseEntity.ok(orders);
    }

    @MessageMapping("/app/subscribe")
    @SendTo("/topic/orders")
    public void connectWebSocket() {
        logger.info("WebSocket connected!");
    }
}
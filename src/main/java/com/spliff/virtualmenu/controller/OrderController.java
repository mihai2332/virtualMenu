package com.spliff.virtualmenu.controller;

import com.spliff.virtualmenu.entity.dto.OrderDTO;
import com.spliff.virtualmenu.service.OrderingTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/order")
public class OrderController {
    @Autowired
    OrderingTableService tableService;

    @PostMapping()
    public ResponseEntity addOrder(@RequestBody OrderDTO orderDTO) {
        tableService.addOrder(orderDTO);
        return ResponseEntity.ok().build();
    }
}

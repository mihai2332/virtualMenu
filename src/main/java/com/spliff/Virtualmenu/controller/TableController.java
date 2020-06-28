package com.spliff.Virtualmenu.controller;

import com.spliff.Virtualmenu.entity.OrderingTable;
import com.spliff.Virtualmenu.entity.dto.TableDTO;
import com.spliff.Virtualmenu.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/table")
public class TableController {
    @Autowired
    TableService tableService;

    @PostMapping(value = "")
    public ResponseEntity addTable(@RequestBody TableDTO tableDTO) {
        OrderingTable orderingTable = tableService.addTable(tableDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderingTable);
    }

    @PutMapping()
    public ResponseEntity editTable(@RequestBody TableDTO tableDTO) {
        OrderingTable orderingTable = tableService.editTable(tableDTO);
        return ResponseEntity.ok().body(orderingTable);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTable(@PathVariable Integer id) {
        tableService.deleteTable(id);
        return ResponseEntity.ok().build();
    }
}

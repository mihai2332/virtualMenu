package com.spliff.virtualmenu.controller;

import com.spliff.virtualmenu.entity.Category;
import com.spliff.virtualmenu.entity.OrderingTable;
import com.spliff.virtualmenu.entity.Product;
import com.spliff.virtualmenu.service.CategoryService;
import com.spliff.virtualmenu.service.OrderingTableService;
import com.spliff.virtualmenu.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
@RequestMapping(value = "/restaurant")
public class RestaurantController {

    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @Autowired
    OrderingTableService tableService;

    @GetMapping(value = "/{uuid}/category")
    public ResponseEntity getAllCategories(@PathVariable(name = "uuid") String restaurantUUID) {
        Set<Category> categories = categoryService.getAllCategories(restaurantUUID);
        return ResponseEntity.ok(categories);
    }

    @GetMapping(value = "/{uuid}/product")
    public ResponseEntity getAllProducts(@PathVariable(name = "uuid") String restaurantUUID) {
        Set<Product> products = productService.getAllProducts(restaurantUUID);
        return ResponseEntity.ok(products);
    }

    @GetMapping(value = "/{uuid}/table")
    public ResponseEntity getAllTables(@PathVariable(name = "uuid") String restaurantUUID) {
        Set<OrderingTable> tables = tableService.getAllTables(restaurantUUID);
        return ResponseEntity.ok(tables);
    }
}

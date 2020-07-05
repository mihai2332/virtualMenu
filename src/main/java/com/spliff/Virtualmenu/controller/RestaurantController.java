package com.spliff.Virtualmenu.controller;

import com.spliff.Virtualmenu.entity.Category;
import com.spliff.Virtualmenu.entity.OrderingTable;
import com.spliff.Virtualmenu.entity.Product;
import com.spliff.Virtualmenu.service.CategoryService;
import com.spliff.Virtualmenu.service.OrderingTableService;
import com.spliff.Virtualmenu.service.ProductService;
import com.spliff.Virtualmenu.service.RestaurantService;
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
    @Autowired
    RestaurantService restaurantService;

    @GetMapping(value = "/{uuid}")
    public ResponseEntity getRestaurantByUUID(@PathVariable(name = "uuid") String restaurantUUID) {
        return ResponseEntity.ok(restaurantService.getRestaurantBy(restaurantUUID));
    }

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

    @GetMapping(value = "/{uuid}/product/{id}")
    public ResponseEntity getAllProducts(@PathVariable(name = "uuid") String restaurantUUID, @PathVariable(name = "id") Integer productId) {
        Product product = productService.getProductFromId(productId, restaurantUUID);
        return ResponseEntity.ok(product);
    }

    @GetMapping(value = "/{uuid}/table")
    public ResponseEntity getAllTables(@PathVariable(name = "uuid") String restaurantUUID) {
        Set<OrderingTable> tables = tableService.getAllTables(restaurantUUID);
        return ResponseEntity.ok(tables);
    }
}

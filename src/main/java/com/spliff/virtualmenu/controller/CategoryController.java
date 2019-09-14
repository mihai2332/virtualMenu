package com.spliff.virtualmenu.controller;

import com.spliff.virtualmenu.entity.Category;
import com.spliff.virtualmenu.entity.Product;
import com.spliff.virtualmenu.service.CategoryService;
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
public class CategoryController {

    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;

    @GetMapping(value = "/{uuid}/category")
    public ResponseEntity getAllCategories(@PathVariable(name = "uuid") String restaurantUUID) {
        Set<Category> categories = categoryService.getAllCategories(restaurantUUID);
        return ResponseEntity.ok(categories);
    }

    @GetMapping(value = "/{uuid}/category/{id}")
    public ResponseEntity getAllCategories(@PathVariable(name = "uuid") String restaurantUUID,
                                           @PathVariable(name = "id") Integer categoryId) {
        Set<Product> products = productService.getAllProductsFromCategory(categoryId);
        return ResponseEntity.ok(products);
    }
}

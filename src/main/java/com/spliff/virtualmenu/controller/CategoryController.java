package com.spliff.virtualmenu.controller;

import com.spliff.virtualmenu.entity.Category;
import com.spliff.virtualmenu.entity.Product;
import com.spliff.virtualmenu.entity.dto.CategoryDTO;
import com.spliff.virtualmenu.service.CategoryService;
import com.spliff.virtualmenu.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;

    @GetMapping(value = "/{id}")
    public ResponseEntity getAllCategories(@PathVariable(name = "id") Integer categoryId) {
        Set<Product> products = productService.getAllProductsFromCategory(categoryId);
        return ResponseEntity.ok(products);
    }

    @PostMapping(value = "")
    public ResponseEntity createCategory(@RequestBody CategoryDTO dto) {
        Category category = categoryService.createCategory(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(category);
    }
}

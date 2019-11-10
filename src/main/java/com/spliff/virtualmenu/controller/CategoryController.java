package com.spliff.virtualmenu.controller;

import com.spliff.virtualmenu.entity.Category;
import com.spliff.virtualmenu.entity.Product;
import com.spliff.virtualmenu.entity.dto.CategoryDTO;
import com.spliff.virtualmenu.entity.dto.ProductDTO;
import com.spliff.virtualmenu.service.CategoryService;
import com.spliff.virtualmenu.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Set;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;

    @GetMapping(value = "/{id}")
    public ResponseEntity getAllProductsFromCategory(@PathVariable(name = "id") Integer categoryId) {
        Set<Product> products = productService.getAllProductsFromCategory(categoryId);
        return ResponseEntity.ok(products);
    }

    @PostMapping(value = "")
    public ResponseEntity createCategory(@RequestBody CategoryDTO dto) {
        Category category = categoryService.createCategory(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(category);
    }

    @PutMapping()
    public ResponseEntity editCategory(@RequestBody CategoryDTO categoryDTO) {
        Category category = categoryService.editCategory(categoryDTO);
        return ResponseEntity.ok().body(category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCategory(@PathVariable Integer id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/upload")
    public ResponseEntity categoryImageUpload(@RequestParam("image") MultipartFile imageFile,
                                          @PathVariable Integer id) {
        if (imageFile.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        try {
            byte[] image = imageFile.getBytes();
            categoryService.attachPicture(id, image);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/picture")
    public ResponseEntity getPicture(@PathVariable Integer id) {
        return ResponseEntity.ok().body(categoryService.getPicture(id));
    }
}

package com.spliff.virtualmenu.controller;

import com.spliff.virtualmenu.entity.Product;
import com.spliff.virtualmenu.entity.dto.ProductDTO;
import com.spliff.virtualmenu.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PutMapping("/{id}")
    public ResponseEntity switchState(@PathVariable Integer id,
                                      @RequestParam Boolean active) {
        Product product = productService.switchState(id, active);
        return ResponseEntity.ok().body(product);
    }

    @PostMapping()
    public ResponseEntity addProduct(@RequestBody ProductDTO productDTO) {
        Product product = productService.addProduct(productDTO);
        return ResponseEntity.ok().body(product);
    }
}

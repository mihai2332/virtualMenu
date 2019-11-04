package com.spliff.virtualmenu.controller;

import com.spliff.virtualmenu.entity.Product;
import com.spliff.virtualmenu.entity.dto.ProductDTO;
import com.spliff.virtualmenu.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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

    @PutMapping()
    public ResponseEntity editProduct(@RequestBody ProductDTO productDTO) {
        Product product = productService.editProduct(productDTO);
        return ResponseEntity.ok().body(product);
    }

    @PostMapping("/{id}/upload")
    public ResponseEntity mainImageUpload(@RequestParam("image") MultipartFile imageFile,
                                          @PathVariable Integer id) {
        if (imageFile.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        try {
            byte[] image = imageFile.getBytes();
            productService.attachPicture(id, image);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/picture")
    public ResponseEntity getPicture(@PathVariable Integer id) {
        return ResponseEntity.ok().body(productService.getPicture(id));
    }
}

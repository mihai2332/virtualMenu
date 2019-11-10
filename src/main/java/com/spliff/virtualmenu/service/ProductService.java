package com.spliff.virtualmenu.service;

import com.spliff.virtualmenu.entity.Category;
import com.spliff.virtualmenu.entity.Product;
import com.spliff.virtualmenu.entity.Restaurant;
import com.spliff.virtualmenu.entity.dto.ProductDTO;
import com.spliff.virtualmenu.repository.CategoryRepo;
import com.spliff.virtualmenu.repository.ProductRepo;
import com.spliff.virtualmenu.repository.RestaurantRepo;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
public class ProductService {
    private Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    ProductRepo productRepo;
    @Autowired
    CategoryRepo categoryRepo;
    @Autowired
    RestaurantRepo restaurantRepo;
    @Autowired
    CategoryService categoryService;
    @Autowired
    ModelMapper modelMapper;

    public Set<Product> getAllProductsFromCategory(Integer categoryId) {
        Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new IllegalArgumentException("Category not found"));
        Set<Product> products = productRepo.findAllByCategory(category);
        return products;
    }

    public Set<Product> getAllProducts(String restaurantUUID) {
        Restaurant restaurant = restaurantRepo.findByUuid(restaurantUUID).orElseThrow(() -> new IllegalArgumentException("Restaurant not found"));
        return productRepo.findAllByRestaurant(restaurant);
    }

    public Product switchState(Integer id, Boolean active) {
        Product product = productRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not found"));
        product.setActive(active);
        return productRepo.save(product);
    }

    public Product addProduct(ProductDTO productDTO) {
        Category category = categoryRepo.findById(productDTO.category).orElseThrow(() -> new IllegalArgumentException("Category not found"));
        Product product = new Product();
        product.setActive(true);
        product.setDescription(productDTO.description);
        product.setName(productDTO.name);
        product.setPrice(productDTO.price);
        product.setCategory(category);
        product.setRestaurant(category.getRestaurant());
        return productRepo.save(product);
    }

    public void attachPicture(Integer id, byte[] image) {
        Product product = productRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not found"));
        product.setPicture(image);
        productRepo.save(product);
    }

    public byte[] getPicture(Integer id) {
        Product product = productRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not found"));
        return product.getPicture();
    }

    public Product editProduct(ProductDTO productDTO) {
        Category category = null;
        if(productDTO.category != null)
            category = categoryRepo.findById(productDTO.category).orElseThrow(() -> new IllegalArgumentException("Category not found"));
        Product product = productRepo.findById(productDTO.id).orElseThrow(() -> new IllegalArgumentException("Product not found"));
        modelMapper.map(productDTO, product);
        product.setCategory(category);
        return productRepo.save(product);
    }

    @Transactional
    public void deleteProduct( Integer productId) {
        Product product = productRepo.findById(productId).orElseThrow(() -> new IllegalArgumentException("Product not found"));
        productRepo.delete(product);
    }
}

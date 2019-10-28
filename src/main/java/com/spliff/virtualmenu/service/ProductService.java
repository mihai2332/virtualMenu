package com.spliff.virtualmenu.service;

import com.spliff.virtualmenu.entity.Category;
import com.spliff.virtualmenu.entity.Product;
import com.spliff.virtualmenu.repository.CategoryRepo;
import com.spliff.virtualmenu.repository.ProductRepo;
import com.spliff.virtualmenu.repository.RestaurantRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
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

    public Set<Product> getAllProductsFromCategory(Integer categoryId) {
        Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new RuntimeException("Category not found"));
        Set<Product> products = productRepo.findAllByCategory(category);
        return products;
    }

    public Set<Product> getAllProducts(String restaurantUUID) {
        Set<Category> categories = categoryService.getAllCategories(restaurantUUID);
        Set<Product> products = new HashSet<>();
        for (Category category : categories) {
            products.addAll(getAllProductsFromCategory(category.getId()));
        }
        return products;
    }
}

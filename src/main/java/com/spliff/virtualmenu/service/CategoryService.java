package com.spliff.virtualmenu.service;

import com.spliff.virtualmenu.entity.Category;
import com.spliff.virtualmenu.entity.Product;
import com.spliff.virtualmenu.entity.Restaurant;
import com.spliff.virtualmenu.entity.dto.CategoryDTO;
import com.spliff.virtualmenu.repository.CategoryRepo;
import com.spliff.virtualmenu.repository.RestaurantRepo;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;

@Service
public class CategoryService {
    private Logger logger = LoggerFactory.getLogger(CategoryService.class);

    @Autowired
    CategoryRepo categoryRepo;
    @Autowired
    RestaurantRepo restaurantRepo;
    @Autowired
    ModelMapper modelMapper;

    public Set<Category> getAllCategories(String restaurantUUID) {
        Restaurant restaurant = restaurantRepo.findByUuid(restaurantUUID).orElseThrow(() -> new EmptyResultDataAccessException(1));
        return categoryRepo.findAllByRestaurant(restaurant);
    }

    public Category createCategory(CategoryDTO dto) {
        Restaurant restaurant = restaurantRepo.findByUuid(dto.restaurantUUID).orElseThrow(() -> new EmptyResultDataAccessException(1));
        Category category = new Category();
        modelMapper.map(dto, category);
        category.setRestaurant(restaurant);
        return categoryRepo.save(category);
    }

    public Category editCategory(CategoryDTO categoryDTO) {
        Category category = categoryRepo.findById(categoryDTO.id).orElseThrow(() -> new IllegalArgumentException("Category not found"));
        Restaurant restaurant = category.getRestaurant();
        modelMapper.map(categoryDTO, category);
        category.setRestaurant(restaurant);
        return categoryRepo.save(category);
    }

    public void deleteCategory(Integer id) {
        Category category = categoryRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Category not found"));
        categoryRepo.delete(category);
    }

    public void attachPicture(Integer id, byte[] image) {
        Category category = categoryRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Category not found"));
        category.setPicture(image);
        categoryRepo.save(category);
    }

    public byte[] getPicture(Integer id) {
        Category category = categoryRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Category not found"));
        return category.getPicture();
    }
}

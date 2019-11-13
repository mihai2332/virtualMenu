package com.spliff.virtualmenu.repository;

import com.spliff.virtualmenu.entity.Category;
import com.spliff.virtualmenu.entity.Product;
import com.spliff.virtualmenu.entity.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ProductRepo extends CrudRepository<Product, Integer> {
    Set<Product> findAllByCategory(Category category);
    Set<Product> findAllByRestaurant(Restaurant restaurant);
    Set<Product> findAllByIdIn(List<Integer> productIds);
}

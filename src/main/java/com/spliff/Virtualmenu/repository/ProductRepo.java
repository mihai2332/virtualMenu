package com.spliff.Virtualmenu.repository;

import com.spliff.Virtualmenu.entity.Category;
import com.spliff.Virtualmenu.entity.Product;
import com.spliff.Virtualmenu.entity.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface ProductRepo extends CrudRepository<Product, Integer> {
    Set<Product> findAllByCategory(Category category);
    Set<Product> findAllByRestaurant(Restaurant restaurant);
    Optional<Product> findByIdAndRestaurant(Integer Id, Restaurant restaurant);
}

package com.spliff.virtualmenu.repository;

import com.spliff.virtualmenu.entity.Category;
import com.spliff.virtualmenu.entity.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Integer> {
    Set<Category> findAllByRestaurant(Restaurant restaurant);
}

package com.spliff.Virtualmenu.repository;

import com.spliff.Virtualmenu.entity.Category;
import com.spliff.Virtualmenu.entity.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Integer> {
    Set<Category> findAllByRestaurant(Restaurant restaurant);
}

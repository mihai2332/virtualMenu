package com.spliff.virtualmenu.repository;

import com.spliff.virtualmenu.entity.Category;
import com.spliff.virtualmenu.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ProductRepo extends CrudRepository<Product, Integer> {
    Set<Product> findAllByCategory(Category category);
}

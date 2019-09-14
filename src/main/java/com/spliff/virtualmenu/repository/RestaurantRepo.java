package com.spliff.virtualmenu.repository;

import com.spliff.virtualmenu.entity.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RestaurantRepo extends CrudRepository<Restaurant, Integer> {
    Optional<Restaurant> findByUuid(String uuid);
}

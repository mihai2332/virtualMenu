package com.spliff.Virtualmenu.service;

import com.spliff.Virtualmenu.entity.Restaurant;
import com.spliff.Virtualmenu.repository.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepo restaurantRepo;

    public Restaurant getRestaurantBy(String uuid) {
        return restaurantRepo.findByUuid(uuid).orElseThrow(() -> new EmptyResultDataAccessException(1));
    }
}

package com.spliff.virtualmenu.service;

import com.spliff.virtualmenu.entity.OrderingTable;
import com.spliff.virtualmenu.entity.Product;
import com.spliff.virtualmenu.entity.Restaurant;
import com.spliff.virtualmenu.repository.OrderingTableRepo;
import com.spliff.virtualmenu.repository.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OrderingTableService {
    @Autowired
    OrderingTableRepo tableRepo;
    @Autowired
    RestaurantRepo restaurantRepo;

    public Set<OrderingTable> getAllTables(String restaurantUUID) {
        Restaurant restaurant = restaurantRepo.findByUuid(restaurantUUID).orElseThrow(() -> new IllegalArgumentException("Restaurant not found"));
        return tableRepo.findAllByRestaurant(restaurant);
    }
}

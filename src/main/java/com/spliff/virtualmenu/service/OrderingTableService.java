package com.spliff.virtualmenu.service;

import com.spliff.virtualmenu.entity.*;
import com.spliff.virtualmenu.entity.dto.OrderDTO;
import com.spliff.virtualmenu.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class OrderingTableService {
    @Autowired
    OrderingTableRepo tableRepo;
    @Autowired
    OrderRepo orderRepo;
    @Autowired
    RestaurantRepo restaurantRepo;
    @Autowired
    ProductRepo productRepo;
    @Autowired
    OrderToProductRelationRepo relationRepo;

    public Set<OrderingTable> getAllTables(String restaurantUUID) {
        Restaurant restaurant = restaurantRepo.findByUuid(restaurantUUID).orElseThrow(() -> new IllegalArgumentException("Restaurant not found"));
        return tableRepo.findAllByRestaurant(restaurant);
    }

    public void addOrder(OrderDTO orderDTO) {
        AtomicReference<Integer> totalPrice = new AtomicReference<>();
        totalPrice.set(0);
        OrderingTable orderingTable = tableRepo.findById(orderDTO.tableId).orElseThrow(() -> new IllegalArgumentException("Table not found"));
        Order order = orderRepo.save(new Order.Builder()
                .totalPrice(totalPrice.get())
                .orderingTable(orderingTable)
                .build());
        orderDTO.orderedItems.forEach(item -> {
            Product product = productRepo.findById(item.productId).orElseThrow(() -> new IllegalArgumentException("Product not found"));
            totalPrice.set(totalPrice.get() + item.quantity * product.getPrice());
            relationRepo.save(new OrderToProductRelation(product, order, item.quantity));
        });
    }
}

package com.spliff.Virtualmenu.repository;

import com.spliff.Virtualmenu.entity.Order;
import com.spliff.Virtualmenu.entity.Restaurant;
import com.spliff.Virtualmenu.entity.ORDER_STATUS;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface OrderRepo extends CrudRepository<Order, Integer> {
    Set<Order> findAllByOrderStatus(ORDER_STATUS orderStatus);
    Set<Order> findAllByRestaurantAndOrderStatus(Restaurant restaurant, ORDER_STATUS orderStatus);
}

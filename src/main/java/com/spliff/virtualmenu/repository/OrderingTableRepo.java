package com.spliff.virtualmenu.repository;

import com.spliff.virtualmenu.entity.OrderingTable;
import com.spliff.virtualmenu.entity.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface OrderingTableRepo extends CrudRepository<OrderingTable, Integer> {
    Set<OrderingTable> findAllByRestaurant(Restaurant restaurant);
}

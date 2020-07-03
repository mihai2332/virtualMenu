package com.spliff.Virtualmenu.repository;

import com.spliff.Virtualmenu.entity.OrderingTable;
import com.spliff.Virtualmenu.entity.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface OrderingTableRepo extends CrudRepository<OrderingTable, Integer> {
    Set<OrderingTable> findAllByRestaurant(Restaurant restaurant);
}

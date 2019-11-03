package com.spliff.virtualmenu.repository;

import com.spliff.virtualmenu.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends CrudRepository<Order, Integer> {
}

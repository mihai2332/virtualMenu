package com.spliff.Virtualmenu.repository;

import com.spliff.Virtualmenu.entity.Order;
import com.spliff.Virtualmenu.entity.OrderToProductRelation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface OrderToProductRelationRepo extends CrudRepository<OrderToProductRelation, Integer> {
    Set<OrderToProductRelation> findAllByOrder(Order order);
}

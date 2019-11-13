package com.spliff.virtualmenu.repository;

import com.spliff.virtualmenu.entity.OrderToProductRelation;
import org.springframework.data.repository.CrudRepository;

public interface OrderToProductRelationRepo extends CrudRepository<OrderToProductRelation, Integer> {
}

package com.spliff.Virtualmenu.repository;

import com.spliff.Virtualmenu.entity.OrderToProductRelation;
import org.springframework.data.repository.CrudRepository;

public interface OrderToProductRelationRepo extends CrudRepository<OrderToProductRelation, Integer> {
}

package com.spliff.Virtualmenu.repository;

import com.spliff.Virtualmenu.entity.Order;
import com.spliff.Virtualmenu.entity.STATUS;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface OrderRepo extends CrudRepository<Order, Integer> {
    Optional<Order> findByUuid(String uuid);
    Set<Order> findAllByStatus(STATUS status);
}

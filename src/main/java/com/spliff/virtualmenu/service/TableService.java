package com.spliff.virtualmenu.service;

import com.spliff.virtualmenu.entity.OrderingTable;
import com.spliff.virtualmenu.entity.Restaurant;
import com.spliff.virtualmenu.entity.dto.TableDTO;
import com.spliff.virtualmenu.repository.OrderingTableRepo;
import com.spliff.virtualmenu.repository.RestaurantRepo;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class TableService {
    @Autowired
    RestaurantRepo restaurantRepo;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    OrderingTableRepo orderingTableRepo;
    private Logger logger = LoggerFactory.getLogger(TableService.class);

    public Set<OrderingTable> getAllTables(String restaurantUUID) {
        Restaurant restaurant = restaurantRepo.findByUuid(restaurantUUID).orElseThrow(() -> new EmptyResultDataAccessException(1));
        return orderingTableRepo.findAllByRestaurant(restaurant);
    }

    public OrderingTable addTable(TableDTO tableDTO) {
        Restaurant restaurant = restaurantRepo.findByUuid(tableDTO.restaurant.getUuid()).orElseThrow(() -> new EmptyResultDataAccessException(1));
        OrderingTable orderingTable = new OrderingTable();
        modelMapper.map(tableDTO, orderingTable);
        orderingTable.setRestaurant(restaurant);
        orderingTable.setReserved(false);
        orderingTable.setOrders(null);
        return orderingTableRepo.save(orderingTable);
    }

    public OrderingTable editTable(TableDTO tableDTO) {
        Restaurant restaurant = restaurantRepo.findByUuid(tableDTO.restaurant.getUuid()).orElseThrow(() -> new EmptyResultDataAccessException(1));
        OrderingTable orderingTable = orderingTableRepo.findById(tableDTO.id).orElseThrow(() -> new IllegalArgumentException("Table not found"));
        modelMapper.map(tableDTO, orderingTable);
        orderingTable.setRestaurant(restaurant);
        orderingTable.setReserved(false);
        return orderingTableRepo.save(orderingTable);
    }

    public void deleteTable(Integer id) {
        OrderingTable orderingTable = orderingTableRepo.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
        orderingTableRepo.delete(orderingTable);
    }
}

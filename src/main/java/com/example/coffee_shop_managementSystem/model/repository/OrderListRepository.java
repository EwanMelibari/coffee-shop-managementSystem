package com.example.coffee_shop_managementSystem.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.coffee_shop_managementSystem.model.entity.OrderList;

public interface OrderListRepository extends JpaRepository<OrderList, Integer> {
    
}

package com.example.coffee_shop_managementSystem.model.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;

@Entity
public class Order {

    private Integer orderId;
    private LocalDateTime orderDate = LocalDateTime.now();
    private User cashier;
    private Double totalPrice;
    private List<OrderList> orderList = new ArrayList<>();

    public Order() {
    }

    public Order(Integer orderId, User cashier, Double totalPrice) {
        this.orderId = orderId;
        this.cashier = cashier;
        this.totalPrice = totalPrice;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public User getCashier() {
        return cashier;
    }

    public void setCashier(User cashier) {
        this.cashier = cashier;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totaDouble) {
        this.totalPrice = totaDouble;
    }

    public List<OrderList> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderList> orderList) {
        this.orderList = orderList;
    }

}

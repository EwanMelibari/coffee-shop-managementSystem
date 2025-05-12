package com.example.coffee_shop_managementSystem.model.entity;

import jakarta.persistence.Entity;

@Entity
public class OrderList {
    
    private Integer orderListId;
    private Order order;
    private Product product;
    private Integer quantity;

    public OrderList(Integer orderListId, Order order, Product product, Integer quantity) {
        this.orderListId = orderListId;
        this.order = order;
        this.product = product;
        this.quantity = quantity;
    }

    public OrderList() {
    }

    public Integer getOrderListId() {
        return orderListId;
    }

    public void setOrderListId(Integer orderListId) {
        this.orderListId = orderListId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


}

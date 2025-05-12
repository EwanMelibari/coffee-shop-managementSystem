package com.example.coffee_shop_managementSystem.model.entity;

import com.example.coffee_shop_managementSystem.model.entity.enums.ProductType;

import jakarta.persistence.Entity;

@Entity
public class Product {
    
    private Integer productId;
    private String name;
    private Double price;
    private ProductType type;

    public Product(Integer productId, String name, Double price, ProductType type) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }
    

}

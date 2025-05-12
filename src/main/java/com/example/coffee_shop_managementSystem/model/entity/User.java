package com.example.coffee_shop_managementSystem.model.entity;

import com.example.coffee_shop_managementSystem.model.entity.enums.PersonRole;

import jakarta.persistence.Entity;

@Entity
public class User {
    
    private Integer id;
    private String username;
    private Integer password;
    private PersonRole role;
    private Double salary;
    
    public User(Integer id,String username, Integer password, PersonRole role, Double salary) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public Integer getPassword() {
        return password;
    }
    
    public void setPassword(Integer password) {
        this.password = password;
    }
    
    public PersonRole getRole() {
        return role;
    }
    
    public void setRole(PersonRole role) {
        this.role = role;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

}
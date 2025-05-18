package com.example.coffee_shop_managementSystem.model.entity;

import com.example.coffee_shop_managementSystem.model.entity.enums.PersonRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "users")
public class User {

   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // أضف هذه السطر
    private Integer id; // تعيين قيمة عشوائية للمعرف

    @Column(name = "username", nullable = false)
    private String username;

   @Column(name = "password", nullable = false)
    private String password;

   @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private PersonRole role;

    @Column(name = "salary", nullable = false)
    @Max(value = 30000)
    @Min(value = 5000)
    private Double salary;
    
    public User(String username, String password, PersonRole role, Double salary) {
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
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
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
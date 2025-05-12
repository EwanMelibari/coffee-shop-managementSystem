package com.example.coffee_shop_managementSystem.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.coffee_shop_managementSystem.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    


}

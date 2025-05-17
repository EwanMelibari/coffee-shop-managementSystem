package com.example.coffee_shop_managementSystem.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.coffee_shop_managementSystem.model.entity.User;
import com.example.coffee_shop_managementSystem.model.entity.enums.PersonRole;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    
List<User> findByRole(String role);
List<User> findByUsername(String username);

@Query("SELECT u FROM User u WHERE u.username = ?1 AND u.password = ?2")
List<User> findByUsernameAndPassword(String username, String password);


@Query("SELECT u FROM User u WHERE u.role = 'CASHIER'")
List<User> findByRole(PersonRole role);



}

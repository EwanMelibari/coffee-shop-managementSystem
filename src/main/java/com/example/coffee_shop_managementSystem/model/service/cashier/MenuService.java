package com.example.coffee_shop_managementSystem.model.service.cashier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.coffee_shop_managementSystem.model.entity.Product;
import com.example.coffee_shop_managementSystem.model.repository.ProductRepository;



@Service
public class MenuService {

    @Autowired
    private ProductRepository productRepository;
 

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

   

    public List<Product> displayMenu() {
        return productRepository.findAll();
    }
    


    
}

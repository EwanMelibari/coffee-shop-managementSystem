package com.example.coffee_shop_managementSystem.model.service.cashier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.coffee_shop_managementSystem.model.entity.Product;
import com.example.coffee_shop_managementSystem.model.repository.OrderListRepository;
import com.example.coffee_shop_managementSystem.model.repository.OrderRepository;
import com.example.coffee_shop_managementSystem.model.repository.ProductRepository;



@Service
public class MenuService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderListRepository orderListRepository;    

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // a method to add product to the order
   

    // display menu
    public List<Product> displayMenu() {
        return productRepository.findAll();
    }
    

   

    
}

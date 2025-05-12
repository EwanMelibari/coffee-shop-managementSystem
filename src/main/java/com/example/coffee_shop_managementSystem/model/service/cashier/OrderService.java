package com.example.coffee_shop_managementSystem.model.service.cashier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.coffee_shop_managementSystem.model.entity.Order;
import com.example.coffee_shop_managementSystem.model.entity.Product;
import com.example.coffee_shop_managementSystem.model.entity.User;
import com.example.coffee_shop_managementSystem.model.repository.OrderRepository;
import com.example.coffee_shop_managementSystem.model.repository.ProductRepository;

@Service
public class OrderService {
    
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;
    
    public Order createOrder(Order order , User cashier){

        order.setCashier(cashier);
        
        OrderService orderService = new OrderService();
        orderService.calculateTotalPrice(order);
        
        return orderRepository.save(order);
    }

   public void calculateTotalPrice(Order order) {
        double total = order.getOrderList().stream()
                .mapToDouble(item -> {
                    Product product = productRepository.findById(item.getProduct().getProductId())
                            .orElseThrow(() -> new RuntimeException("Product not found"));
                    
                    return product.getPrice() * item.getQuantity();
                })
                .sum();
        
        order.setTotalPrice(total);
    }

}

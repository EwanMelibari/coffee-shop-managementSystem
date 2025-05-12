package com.example.coffee_shop_managementSystem.model.service.cashier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.coffee_shop_managementSystem.model.entity.Order;
import com.example.coffee_shop_managementSystem.model.entity.OrderList;
import com.example.coffee_shop_managementSystem.model.entity.Product;
import com.example.coffee_shop_managementSystem.model.entity.User;
import com.example.coffee_shop_managementSystem.model.repository.OrderListRepository;
import com.example.coffee_shop_managementSystem.model.repository.OrderRepository;
import com.example.coffee_shop_managementSystem.model.repository.ProductRepository;

@Service
public class OrderService {
    
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderListRepository orderListRepository; 
    
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

     public void addProductToOrder(Integer orderId, Integer productId, Integer quantity) {
        // Find the order by ID
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order != null) {
            // Find the product by ID
            Product product = productRepository.findById(productId).orElse(null);
            if (product != null) {
                // Create a new OrderList object and set its properties
                OrderList orderList = new OrderList();
                orderList.setOrder(order);
                orderList.setProduct(product);
                orderList.setQuantity(quantity);

                // Save the OrderList object to the database
                orderListRepository.save(orderList);
            }
        }
    }

    public void removeProductFromOrder(Integer orderId, Integer orderListId) {
        // Find the order by ID
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order != null) {
            // Find the OrderList object by ID
            OrderList orderList = orderListRepository.findById(orderListId).orElse(null);
            if (orderList != null) {
                // Remove the OrderList object from the order
                order.getOrderList().remove(orderList);
                // Delete the OrderList object from the database
                orderListRepository.delete(orderList);
            }
        }

    }

}

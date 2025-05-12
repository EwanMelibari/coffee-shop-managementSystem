package com.example.coffee_shop_managementSystem.model.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.coffee_shop_managementSystem.model.entity.Product;
import com.example.coffee_shop_managementSystem.model.repository.ProductRepository;

@Service
public class ManageProductsService {

    @Autowired
    private ProductRepository productRepository;

    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

    public Product getProductById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    public void updateProduct(Product product) {
       if(productRepository.existsById(product.getProductId())){
           productRepository.save(product);
       }
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    
}

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

    public Product saveProduct(Product product) {
       return productRepository.save(product);
    }

    public void deleteProduct(Integer id) {
    if (!productRepository.existsById(id)) {
        throw new RuntimeException("Product not found with id: " + id);
    }
    productRepository.deleteById(id);
}

    public Product getProductById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product updateProduct(Integer id, Product updatedProduct) {
    Product existingProduct = productRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    
    existingProduct.setName(updatedProduct.getName());
    existingProduct.setPrice(updatedProduct.getPrice());
    existingProduct.setType(updatedProduct.getType());
    
    return productRepository.save(existingProduct);
}

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    
}

package com.example.coffee_shop_managementSystem.controller.adminController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.coffee_shop_managementSystem.model.entity.Product;
import com.example.coffee_shop_managementSystem.model.entity.User;
import com.example.coffee_shop_managementSystem.model.service.admin.ManageEmployeeService;
import com.example.coffee_shop_managementSystem.model.service.admin.ManageProductsService;

@RestController
@RequestMapping("/REST/admin")
public class AdminRestController {

    @Autowired
    private ManageEmployeeService manageEmployeeService;

    @Autowired
    private ManageProductsService manageProductService;

@GetMapping("/welcome")
public String welcome() {
    return "Welcome to the admin page!";
}

@GetMapping("/employees")
public List<User> getAllEmployees() {
    
    return manageEmployeeService.getAllEmployees();
    
}

@PostMapping("/employees/add")
    public User addEmployee(@RequestBody User user) {
        return manageEmployeeService.saveEmployee(user);
    }

@DeleteMapping("/employees/delete/{id}")
    public void deleteEmployee(@PathVariable Integer id) {
        manageEmployeeService.deleteEmployee(id);
    }

    @PutMapping("/employees/update/{id}")
    public User updateEmployee(@PathVariable Integer id, @RequestBody User user) {
        return manageEmployeeService.updateEmployee(id, user);
    }

@GetMapping("/products")
public List<Product> getAllProducts() {
    return manageProductService.getAllProducts();
}


@PostMapping("/products/add")
    public Product addProduct(@RequestBody Product product) {
        return manageProductService.saveProduct(product);
    }

@PutMapping("/products/update/{id}")
    public Product updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        return manageProductService.updateProduct(id, product);
    }


@DeleteMapping("/products/delete/{id}")
public void deleteProduct(@PathVariable Integer id) {
    manageProductService.deleteProduct(id);
}

  @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable Integer id) {
        return manageProductService.getProductById(id);
    }


}
package com.example.coffee_shop_managementSystem.controller.adminController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

@GetMapping("/getAllEmployees")
public List<User> getAllEmployees() {
    
    return manageEmployeeService.getAllEmployees();
    
}

@GetMapping("/getAllProducts")
public String getAllProducts() {
    return "getAllProducts";
}

@GetMapping("/welcome")
public String welcome() {
    return "Welcome to the admin page!";}

}
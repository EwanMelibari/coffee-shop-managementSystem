package com.example.coffee_shop_managementSystem.controller.adminController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

 
    @RequestMapping("/addEmployee")
    public String addEmployee() {
        return "adminPage";
    }

    @RequestMapping("/addProduct")
    public String addProduct() {
        return "adminProduct";
    }

    @RequestMapping("/viewEmployees")
    public String viewEmployees() {
        return "adminPage";
    }

    @RequestMapping("/viewProducts")
    public String viewProducts() {
        return "adminProduct";
    }
    
}
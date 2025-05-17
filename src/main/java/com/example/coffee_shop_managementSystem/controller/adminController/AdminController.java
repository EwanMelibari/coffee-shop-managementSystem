package com.example.coffee_shop_managementSystem.controller.adminController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.coffee_shop_managementSystem.model.service.admin.ManageEmployeeService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ManageEmployeeService manageEmployeeService;
 
    @RequestMapping("/addEmployee")
    public String addEmployee() {
        return "adminPage";
    }

    @RequestMapping("/addProduct")
    public String addProduct() {
        return "adminProduct";
    }

    @GetMapping("/viewEmployees")
    public String viewEmployees(Model model) {
        model.addAttribute("employees", manageEmployeeService.getAllEmployees());
        return "adminPage";
    }

    @RequestMapping("/viewProducts")
    public String viewProducts() {
        return "adminProduct";
    }
    
}
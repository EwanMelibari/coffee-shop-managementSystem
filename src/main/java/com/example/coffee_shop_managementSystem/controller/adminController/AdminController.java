package com.example.coffee_shop_managementSystem.controller.adminController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.coffee_shop_managementSystem.model.entity.User;
import com.example.coffee_shop_managementSystem.model.service.admin.ManageEmployeeService;
import com.example.coffee_shop_managementSystem.model.service.admin.ManageProductsService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ManageEmployeeService manageEmployeeService;

    @Autowired
    private ManageProductsService manageProductService;


   @GetMapping("/employeesAdd")
    public String showAddEmployeeForm(Model model, User user) {
        model.addAttribute("employee", user);
        return "addEmployeeForm";
    }

    @GetMapping("/viewEmployees")
    public String viewEmployees(Model model) {
        model.addAttribute("employees", manageEmployeeService.getAllEmployees());
        return "adminPage";
    }

    @PostMapping("/employeesAdd")
    public String addEmployee(@ModelAttribute("employee") User user) {
        manageEmployeeService.saveEmployee(user);
        return "redirect:/admin/viewEmployees";
    }

    // إدارة المنتجات
    @GetMapping("/addProduct")
    public String addProductPage() {
        return "addProductForm";
    }

    @GetMapping("/viewProducts")
    public String viewProducts(Model model) {
        model.addAttribute("products", manageProductService.getAllProducts());
        return "adminProduct";
    }

    // صفحات التعديل
    @GetMapping("/editEmployee/{id}")
    public String editEmployeePage(@PathVariable Integer id, Model model) {
        model.addAttribute("employee", manageEmployeeService.getEmployeeById(id));
        return "editEmployeeForm";
    }

    @GetMapping("/editProduct/{id}")
    public String editProductPage(@PathVariable Integer id, Model model) {
        model.addAttribute("product", manageProductService.getProductById(id));
        return "editProductForm";
    }

    @PostMapping("/updateEmployee/{id}")
    public String updateEmployee(@PathVariable Integer id, @ModelAttribute User user) {
        manageEmployeeService.updateEmployee(id, user);
        return "redirect:/admin/viewEmployees";
    }

}
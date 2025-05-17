package com.example.coffee_shop_managementSystem.model.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.coffee_shop_managementSystem.model.entity.User;
import com.example.coffee_shop_managementSystem.model.entity.enums.PersonRole;
import com.example.coffee_shop_managementSystem.model.repository.UserRepository;

@Service
public class ManageEmployeeService {

    @Autowired
    private UserRepository userRepository;

    public User saveEmployee(User user){
       return userRepository.save(user);

    }

    public void deleteEmployee(Integer id) {
    if (!userRepository.existsById(id)) {
        throw new RuntimeException("Employee not found with id: " + id);
    }
    userRepository.deleteById(id);
}

    public List<User> getAllEmployees() {
    return userRepository.findByRole(PersonRole.CASHIER);
}

    public User updateEmployee(Integer id, User updatedUser) {
    User existingUser = userRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    
    existingUser.setUsername(updatedUser.getUsername());
    existingUser.setPassword(updatedUser.getPassword());
    existingUser.setRole(updatedUser.getRole());
    existingUser.setSalary(updatedUser.getSalary());
    
    return userRepository.save(existingUser);
}

    public User getEmployeeById(Integer id){
        return userRepository.findById(id).orElse(null);
    }
    
}

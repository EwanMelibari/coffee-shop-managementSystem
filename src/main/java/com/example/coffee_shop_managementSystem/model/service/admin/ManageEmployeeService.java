package com.example.coffee_shop_managementSystem.model.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.coffee_shop_managementSystem.model.entity.User;
import com.example.coffee_shop_managementSystem.model.repository.UserRepository;

@Service
public class ManageEmployeeService {

    @Autowired
    private UserRepository userRepository;

    public void saveEmployee(User user){
        userRepository.save(user);

    }

    public void deleteEmployee(Integer id){
        userRepository.deleteById(id);
    }

    public List<User> getAllEmployees(){
        return userRepository.findAll();
    }

    public void updateEmployee(User user){
        if(userRepository.existsById(user.getId())){
            userRepository.save(user);
        }
    }

    public User getEmployeeById(Integer id){
        return userRepository.findById(id).orElse(null);
    }
    
}

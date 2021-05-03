package com.example.UserRegistration.controller;


import com.example.UserRegistration.domain.User;
import com.example.UserRegistration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public String homePage(){
        return "home";
    }

    @GetMapping("/register")
    public String registrationPage(Model model){
        model.addAttribute("user",new User());
        return "registration_form";
    }

    @PostMapping("/register_completion")
    private String registerCompletion(User user){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepository.save(user);

        return "register_completion";
    }

    @GetMapping("/users")
    public String userList(Model model){
        List<User> list_of_user = userRepository.findAll();
        model.addAttribute("list_of_user",list_of_user);
        return "users";
    }

}

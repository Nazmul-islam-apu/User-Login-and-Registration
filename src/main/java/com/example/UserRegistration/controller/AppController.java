package com.example.UserRegistration.controller;

import com.example.UserRegistration.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.PrivateKey;

@Controller
public class AppController {

    private UserRepository userRepository;

    @GetMapping("/")
    public String home(){
        return "index";
    }
}

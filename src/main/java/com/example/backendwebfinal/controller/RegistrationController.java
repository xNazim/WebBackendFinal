package com.example.backendwebfinal.controller;

import com.example.backendwebfinal.entity.User;
import com.example.backendwebfinal.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {



    @Autowired
    private MyUserDetailsService userDetailsService;


    @ModelAttribute("user")
    public User userRegistration() {
        return new User();
    }

    @GetMapping("/registration")
    String registration(Model model) {
        model.addAttribute("users", new User());
        return "registration";
    }

    @PostMapping("/registration")
        String userRegistration(@ModelAttribute("user") User user) {
        userDetailsService.saveUser(user);
        return "redirect:/login";
    }
}

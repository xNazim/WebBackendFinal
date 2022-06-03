package com.example.backendwebfinal.controller;

import com.example.backendwebfinal.entity.Role;
import com.example.backendwebfinal.entity.User;
import com.example.backendwebfinal.repository.RoleRepository;
import com.example.backendwebfinal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    @GetMapping("/registration")
    String registration(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleRepository.findAll());
        return "registration";
    }

    @PostMapping("/registration")
        String userRegistration(@ModelAttribute User user) {
        userRepository.save(user);
        return "redirect:/";
    }
}

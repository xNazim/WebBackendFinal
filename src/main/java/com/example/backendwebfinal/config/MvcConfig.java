package com.example.backendwebfinal.config;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/doctor").setViewName("/doctor");
        registry.addViewController("/admin").setViewName("/admin");
    }
}

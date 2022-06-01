package com.example.backendwebfinal.controller;

import com.example.backendwebfinal.entity.Doctor;
import com.example.backendwebfinal.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping
    String adminView() {
        return  "admin/index";
    }

    @GetMapping("/doctor")
    String adminDoctorView() {
        return  "doctor/dashboard";
    }

    @GetMapping("/patient")
    String adminPatientView() {
        return  "patient/patient";
    }

    @GetMapping("/appointment")
    String adminAppointmentView() {
        return  "appointment/appointment";
    }

    @GetMapping("/donor")
    String adminDonorView() {
        return  "donor/donor";
    }

    @GetMapping("/laboratory")
    String adminLaboratoryView() {
        return  "laboratory/laboratory";
    }

    @PostMapping("/addDoctor")
    public String createDoctor(@ModelAttribute Doctor doctor) {
        doctorRepository.save(doctor);
        return "redirect:dashboard";
    }


}

package com.example.backendwebfinal.controller;

import com.example.backendwebfinal.entity.*;
import com.example.backendwebfinal.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DonorRepository donorRepository;

    @Autowired
    private LaboratoryRepository laboratoryRepository;

    @GetMapping
    String adminView() {
        return  "admin/index";
    }

    @GetMapping("/doctor")
    public String doctorIndex(Model model) {
        model.addAttribute("doctor", new Doctor());
        model.addAttribute("doctors", doctorRepository.findAll());
        return "admin/doctor/dashboard";
    }

    @GetMapping("/patient")
    String adminPatientView(Model model) {
        model.addAttribute("patient", new Patient());
        model.addAttribute("patients", patientRepository.findAll());
        model.addAttribute("doctors", doctorRepository.findAll());
        model.addAttribute("appointments", appointmentRepository.findAll());
        return  "admin/patient/patient";
    }
    @GetMapping("/appointment")
    public String showAppointment(Model model) {
        model.addAttribute("appointment", new Appointment());
        model.addAttribute("appointments", appointmentRepository.findAll());
        return "admin/appointment/appointment";
    }

    @GetMapping("/donor")
    public String showDonor(Model model) {
        model.addAttribute("donor", new Donor());
        model.addAttribute("donors", donorRepository.findAll());
        model.addAttribute("laboratories", laboratoryRepository.findAll());
        return "admin/donor/donor";
    }

    @GetMapping("/laboratory")
    public String showLab(Model model) {
        model.addAttribute("laboratory", new Laboratory());
        model.addAttribute("laboratories", laboratoryRepository.findAll());
        model.addAttribute("users", userRepository.findAll());
        return "admin/laboratory/laboratory";
    }

    @PostMapping("/doctor")
    public String createDoctor(@ModelAttribute Doctor doctor) {
        doctorRepository.save(doctor);
        return "redirect:/admin/doctor";
    }

    @PostMapping("/patient")
    public String createPatient(@ModelAttribute Patient patient) {
        patientRepository.save(patient);
        return "redirect:/admin/patient";
    }

    @PostMapping("/appointment")
    public String createAppointment(@ModelAttribute Appointment appointment) {
        appointmentRepository.save(appointment);
        return "redirect:/admin/appointment";
    }

    @PostMapping("/donor")
    public String createDonor(@ModelAttribute Donor donor) {
        donorRepository.save(donor);
        return "redirect:/admin/donor";
    }

    @PostMapping("/laboratory")
    public String createLab(@ModelAttribute Laboratory laboratory) {
        laboratoryRepository.save(laboratory);

        return "redirect:/admin/laboratory";
    }

}

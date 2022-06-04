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

@Controller
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorRepository doctorRepository;


    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DonorRepository donorRepository;

    @Autowired
    private LaboratoryRepository laboratoryRepository;

    @GetMapping
    public String dashboardView() {
        return "doctor/doctor";
    }

    @GetMapping("/patient")
    String doctorPatientView(Model model) {
        model.addAttribute("patient", new Patient());
        model.addAttribute("patients", patientRepository.findAll());
        model.addAttribute("doctors", doctorRepository.findAll());
        model.addAttribute("appointments", appointmentRepository.findAll());
        return "doctor/patientDoctor/patientDoctor";
    }

    @GetMapping("/appointment")
    public String showAppointment(Model model) {
        model.addAttribute("appointment", new Appointment());
        model.addAttribute("appointments", appointmentRepository.findAll());
        return "doctor/appointmentDoctor/appointmentDoctor";
    }

    @GetMapping("/donor")
    public String showDonor(Model model) {
        model.addAttribute("donor", new Donor());
        model.addAttribute("donors", donorRepository.findAll());
        model.addAttribute("laboratories", laboratoryRepository.findAll());
        return "doctor/donorDoctor/donorDoctor";
    }

    @GetMapping("/laboratory")
    public String showLab(Model model) {
        model.addAttribute("laboratory", new Laboratory());
        model.addAttribute("laboratories", laboratoryRepository.findAll());
        model.addAttribute("users", userRepository.findAll());
        return "doctor/laboratoryDoctor/laboratoryDoctor";
    }

    @GetMapping("/patient/edit")
    String doctorPatientEdit(Model model) {
        model.addAttribute("patient", new Patient());
        model.addAttribute("patients", patientRepository.findAll());
        model.addAttribute("doctors", doctorRepository.findAll());
        model.addAttribute("appointments", appointmentRepository.findAll());
        return "doctor/patientDoctor/editPatient";
    }

    @GetMapping("/appointment/edit")
    public String editAppointment(Model model) {
        model.addAttribute("appointment", new Appointment());
        model.addAttribute("appointments", appointmentRepository.findAll());
        return "doctor/appointmentDoctor/editAppointment";
    }

    @GetMapping("/donor/edit")
    public String editDonor(Model model) {
        model.addAttribute("donor", new Donor());
        model.addAttribute("donors", donorRepository.findAll());
        model.addAttribute("laboratories", laboratoryRepository.findAll());
        return "doctor/donorDoctor/editDonor";
    }
    @GetMapping("/laboratory/edit")
    public String editLab(Model model) {
        model.addAttribute("laboratory", new Laboratory());
        model.addAttribute("laboratories", laboratoryRepository.findAll());
        model.addAttribute("users", userRepository.findAll());
        return "doctor/laboratoryDoctor/editLab";
    }


    @PostMapping("/patient")
    public String createPatient(@ModelAttribute Patient patient) {
        patientRepository.save(patient);
        return "redirect:/doctor/patient";
    }

    @PostMapping("/appointment")
    public String createAppointment(@ModelAttribute Appointment appointment) {
        appointmentRepository.save(appointment);
        return "redirect:/doctor/appointment";
    }

    @PostMapping("/donor")
    public String createDonor(@ModelAttribute Donor donor) {
        donorRepository.save(donor);
        return "redirect:/doctor/donor";
    }

    @PostMapping("/laboratory")
    public String createLab(@ModelAttribute Laboratory laboratory) {
        laboratoryRepository.save(laboratory);

        return "redirect:/doctor/laboratory";
    }

}

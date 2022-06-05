package com.example.backendwebfinal.controller;

import com.example.backendwebfinal.entity.*;
import com.example.backendwebfinal.repository.*;
import com.example.backendwebfinal.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;


    @Autowired
    private AppService appService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private DonorService donorService;

    @Autowired
    private LabService labService;



    @GetMapping
    public String dashboardView() {
        return "doctor/doctor";
    }

    @GetMapping("/patient")
    String doctorPatientView(Model model) {
        model.addAttribute("patient", new Patient());
        model.addAttribute("patients", patientService.getAllPatients());
        model.addAttribute("doctors", doctorService.getAllDoctors());
        model.addAttribute("appointments", appService.getAllAppointments());
        return "doctor/patientDoctor/patientDoctor";
    }

    @GetMapping("/appointment")
    public String showAppointment(Model model) {
        model.addAttribute("appointment", new Appointment());
        model.addAttribute("appointments", appService.getAllAppointments());
        return "doctor/appointmentDoctor/appointmentDoctor";
    }

    @GetMapping("/donor")
    public String showDonor(Model model) {
        model.addAttribute("donor", new Donor());
        model.addAttribute("donors", donorService.getAllDonors());
        model.addAttribute("laboratories", labService.getAllLabs());
        return "doctor/donorDoctor/donorDoctor";
    }

    @GetMapping("/laboratory")
    public String showLab(Model model) {
        model.addAttribute("laboratory", new Laboratory());
        model.addAttribute("laboratories", labService.getAllLabs());
        return "doctor/laboratoryDoctor/laboratoryDoctor";
    }

    @GetMapping("/patient/edit/{id}")
    String doctorPatientEdit(@PathVariable Integer id, Model model) {
        model.addAttribute("patient", patientService.getPatientById(id));
        model.addAttribute("patients", patientService.getAllPatients());
        model.addAttribute("doctors", doctorService.getAllDoctors());
        model.addAttribute("appointments", appService.getAllAppointments());
        return "doctor/patientDoctor/editPatient";
    }

    @GetMapping("/appointment/edit/{id}")
    public String editAppointment(@PathVariable Integer id, Model model) {
        model.addAttribute("appointment", appService.getAppById(id));
        return "doctor/appointmentDoctor/editAppointment";
    }

    @GetMapping("/donor/edit/{id}")
    public String editDonor(@PathVariable Integer id, Model model) {
        model.addAttribute("donor", donorService.getDonorById(id));
        model.addAttribute("donors", donorService.getAllDonors());
        model.addAttribute("laboratories", labService.getAllLabs());
        return "doctor/donorDoctor/editDonor";
    }
    @GetMapping("/laboratory/edit/{id}")
    public String editLab(@PathVariable Integer id, Model model) {
        model.addAttribute("laboratory", labService.getLabById(id));
        model.addAttribute("laboratories", labService.getAllLabs());
        return "doctor/laboratoryDoctor/editLab";
    }

    @GetMapping("/appointment/{id}")
    public String deleteApp(@PathVariable Integer id){
        appService.deleteAppById(id);
        return "redirect:/doctor/appointment";
    }

    @GetMapping("/donor/{id}")
    public String deleteDonor(@PathVariable Integer id){
        donorService.deleteDonorById(id);
        return "redirect:/doctor/donor";
    }

    @GetMapping("/patient/{id}")
    public String deletePatient(@PathVariable Integer id){
        patientService.deletePatientById(id);
        return "redirect:/doctor/patient";
    }
    @GetMapping("/laboratory/{id}")
    public String deleteLab(@PathVariable Integer id){
        labService.deleteLabById(id);
        return "redirect:/doctor/laboratory";
    }


    @PostMapping("/patient")
    public String createPatient(@ModelAttribute Patient patient) {
        patientService.savePatient(patient);
        return "redirect:/doctor/patient";
    }

    @PostMapping("/appointment")
    public String createAppointment(@ModelAttribute Appointment appointment) {
        appService.saveApp(appointment);
        return "redirect:/doctor/appointment";
    }

    @PostMapping("/donor")
    public String createDonor(@ModelAttribute Donor donor) {
        donorService.saveDonor(donor);
        return "redirect:/doctor/donor";
    }

    @PostMapping("/laboratory")
    public String createLab(@ModelAttribute Laboratory laboratory) {
        labService.saveLab(laboratory);

        return "redirect:/doctor/laboratory";
    }

    @PostMapping("/appointment/edit/{id}")
    public String updateApp(@PathVariable Integer id, @ModelAttribute("appointment") Appointment appointment, Model model){
        Appointment existingApp = appService.getAppById(id);
        existingApp.setId(appointment.getId());
        existingApp.setFullName(appointment.getFullName());
        existingApp.setEmail(appointment.getEmail());
        existingApp.setMessage(appointment.getMessage());
        appService.updateApp(existingApp);
        return  "redirect:/doctor/appointment";
    }

    @PutMapping("/patient/edit/{id}")
    public String updatePatient(@PathVariable Integer id, @ModelAttribute("patient") Patient patient, Model model){
        Patient existingPatient = patientService.getPatientById(id);
        existingPatient.setId(patient.getId());
        existingPatient.setFirstName(patient.getFirstName());
        existingPatient.setLastName(patient.getLastName());
        existingPatient.setEmail(patient.getEmail());
        existingPatient.setPhone(patient.getPhone());
        existingPatient.setSex(patient.getSex());
        existingPatient.setAge(patient.getAge());
        existingPatient.setAppointment(patient.getAppointment());
        existingPatient.setDoctor(patient.getDoctor());
        patientService.updatePatient(existingPatient);
        return  "redirect:/doctor/patient";
    }

    @PostMapping("/laboratory/edit/{id}")
    public String updateLab(@PathVariable Integer id, @ModelAttribute("laboratory") Laboratory laboratory, Model model){
        Laboratory existingLab = labService.getLabById(id);
        existingLab.setId(laboratory.getId());
        existingLab.setLabName(laboratory.getLabName());
        existingLab.setAddress(laboratory.getAddress());
        existingLab.setDonor(laboratory.getDonor());
        labService.updateLab(existingLab);
        return  "redirect:/doctor/laboratory";
    }

    @PostMapping("/donor/edit/{id}")
    public String updateDonor(@PathVariable Integer id, @ModelAttribute("laboratory") Donor donor, Model model){
        Donor existingDonor = donorService.getDonorById(id);
        existingDonor.setId(donor.getId());
        existingDonor.setFullName(donor.getFullName());
        existingDonor.setEmail(donor.getEmail());
        existingDonor.setMessage(donor.getMessage());
        donorService.updateDonor(existingDonor);
        return  "redirect:/doctor/donor";
    }
}

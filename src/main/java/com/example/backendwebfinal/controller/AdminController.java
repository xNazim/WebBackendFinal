package com.example.backendwebfinal.controller;

import com.example.backendwebfinal.entity.*;
import com.example.backendwebfinal.repository.*;
import com.example.backendwebfinal.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private AppService appService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private DonorService donorService;

    @Autowired
    private LabService labService;



    @GetMapping
    String adminView() {
        return  "admin/index";
    }

    @GetMapping("/doctor")
    public String doctorIndex(Model model) {
        model.addAttribute("doctor", new Doctor());
        model.addAttribute("doctors", doctorService.getAllDoctors());
        return "admin/doctorAdmin/dashboard";
    }

    @GetMapping("/patient")
    String adminPatientView(Model model) {
        model.addAttribute("patient", new Patient());
        model.addAttribute("patients", patientService.getAllPatients());
        model.addAttribute("doctors", doctorService.getAllDoctors());
        model.addAttribute("appointments", appService.getAllAppointments());
        return  "admin/patient/patient";
    }
    @GetMapping("/appointment")
    public String showAppointment(Model model) {
        model.addAttribute("appointment", new Appointment());
        model.addAttribute("appointments", appService.getAllAppointments());
        return "admin/appointment/appointment";
    }

    @GetMapping("/donor")
    public String showDonor(Model model) {
        model.addAttribute("donor", new Donor());
        model.addAttribute("donors", donorService.getAllDonors());
        model.addAttribute("laboratories", labService.getAllLabs());
        return "admin/donor/donor";
    }

    @GetMapping("/laboratory")
    public String showLab(Model model) {
        model.addAttribute("laboratory", new Laboratory());
        model.addAttribute("laboratories", labService.getAllLabs());
        model.addAttribute("users", userRepository.findAll());
        return "admin/laboratory/laboratory";
    }

    @GetMapping("/patient/edit/{id}")
    String doctorPatientEdit(@PathVariable Integer id, Model model) {
        model.addAttribute("patient", patientService.getPatientById(id));
        model.addAttribute("patients", patientService.getAllPatients());
        model.addAttribute("doctors", doctorService.getAllDoctors());
        model.addAttribute("appointments", appService.getAllAppointments());
        return "admin/patient/edit";
    }

    @GetMapping("/appointment/edit/{id}")
    public String editAppointment(@PathVariable Integer id, Model model) {
        model.addAttribute("appointment", appService.getAppById(id));
        return "admin/appointment/edit";
    }

    @GetMapping("/donor/edit/{id}")
    public String editDonor(@PathVariable Integer id, Model model) {
        model.addAttribute("donor", donorService.getDonorById(id));
        model.addAttribute("donors", donorService.getAllDonors());
        model.addAttribute("laboratories", labService.getAllLabs());
        return "admin/donor/edit";
    }
    @GetMapping("/laboratory/edit/{id}")
    public String editLab(@PathVariable Integer id, Model model) {
        model.addAttribute("laboratory", labService.getLabById(id));
        model.addAttribute("laboratories", labService.getAllLabs());
        model.addAttribute("users", userRepository.findAll());
        return "admin/laboratory/edit";
    }

    @GetMapping("/doctor/edit/{id}")
    public String editDoctor(@PathVariable Integer id, Model model) {
        model.addAttribute("doctor", doctorService.getDoctorById(id));
        model.addAttribute("doctors", doctorService.getAllDoctors());
        return "admin/doctorAdmin/edit";
    }

    @GetMapping("/appointment/{id}")
    public String deleteApp(@PathVariable Integer id){
        appService.deleteAppById(id);
        return "redirect:/admin/appointment";
    }

    @GetMapping("/donor/{id}")
    public String deleteDonor(@PathVariable Integer id){
        donorService.deleteDonorById(id);
        return "redirect:/admin/donor";
    }

    @GetMapping("/patient/{id}")
    public String deletePatient(@PathVariable Integer id){
        patientService.deletePatientById(id);
        return "redirect:/admin/patient";
    }
    @GetMapping("/laboratory/{id}")
    public String deleteLab(@PathVariable Integer id){
        labService.deleteLabById(id);
        return "redirect:/admin/laboratory";
    }

    @GetMapping("/doctor/{id}")
    public String deleteDoctor(@PathVariable Integer id){
        doctorService.deleteDoctorById(id);
        return "redirect:/admin/doctor";
    }


    @PostMapping("/doctor")
    public String createDoctor(@ModelAttribute Doctor doctor) {
        doctorService.saveDoctor(doctor);
        return "redirect:/admin/doctor";
    }

    @PostMapping("/patient")
    public String createPatient(@ModelAttribute Patient patient) {
        patientService.savePatient(patient);
        return "redirect:/admin/patient";
    }

    @PostMapping("/appointment")
    public String createAppointment(@ModelAttribute Appointment appointment) {
        appService.saveApp(appointment);
        return "redirect:/admin/appointment";
    }

    @PostMapping("/donor")
    public String createDonor(@ModelAttribute Donor donor) {
        donorService.saveDonor(donor);
        return "redirect:/admin/donor";
    }

    @PostMapping("/laboratory")
    public String createLab(@ModelAttribute Laboratory laboratory) {
        labService.saveLab(laboratory);

        return "redirect:/admin/laboratory";
    }

    @PostMapping("/appointment/edit/{id}")
    public String updateApp(@PathVariable Integer id, @ModelAttribute("appointment") Appointment appointment, Model model){
        Appointment existingApp = appService.getAppById(id);
        existingApp.setId(appointment.getId());
        existingApp.setFullName(appointment.getFullName());
        existingApp.setEmail(appointment.getEmail());
        existingApp.setMessage(appointment.getMessage());
        appService.updateApp(existingApp);
        return  "redirect:/admin/appointment";
    }

    @PostMapping("/patient/edit/{id}")
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
        return  "redirect:/admin/patient";
    }

    @PostMapping("/laboratory/edit/{id}")
    public String updateLab(@PathVariable Integer id, @ModelAttribute("laboratory") Laboratory laboratory, Model model){
        Laboratory existingLab = labService.getLabById(id);
        existingLab.setId(laboratory.getId());
        existingLab.setLabName(laboratory.getLabName());
        existingLab.setAddress(laboratory.getAddress());
        existingLab.setDonor(laboratory.getDonor());
        labService.updateLab(existingLab);
        return  "redirect:/admin/laboratory";
    }

    @PostMapping("/donor/edit/{id}")
    public String updateDonor(@PathVariable Integer id, @ModelAttribute("laboratory") Donor donor, Model model){
        Donor existingDonor = donorService.getDonorById(id);
        existingDonor.setId(donor.getId());
        existingDonor.setFullName(donor.getFullName());
        existingDonor.setEmail(donor.getEmail());
        existingDonor.setMessage(donor.getMessage());
        donorService.updateDonor(existingDonor);
        return  "redirect:/admin/donor";
    }

    @PostMapping("/doctor/edit/{id}")
    public String updateDoctor(@PathVariable Integer id, @ModelAttribute("doctor") Doctor doctor, Model model){
        Doctor existingDoctor = doctorService.getDoctorById(id);
        existingDoctor.setId(doctor.getId());
        existingDoctor.setFirstName(doctor.getFirstName());
        existingDoctor.setLastName(doctor.getLastName());
        existingDoctor.setSpecialty(doctor.getSpecialty());
        existingDoctor.setAddress(doctor.getAddress());
        existingDoctor.setMobileNo(doctor.getMobileNo());
        doctorService.updateDoctor(existingDoctor);
        return  "redirect:/admin/doctor";
    }

}

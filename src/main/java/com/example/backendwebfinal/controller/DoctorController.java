package com.example.backendwebfinal.controller;

import com.example.backendwebfinal.exception.DoctorNotFoundException;
import com.example.backendwebfinal.model.Doctor;
import com.example.backendwebfinal.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/doctor")
public class DoctorController{

    @Autowired
    private DoctorRepository doctorRepository;


    @GetMapping("/dashboard")
    public String doctorIndex(Model model) {
        model.addAttribute("doctor", new Doctor());
        model.addAttribute("doctors", doctorRepository.findAll());
        return "doctor/dashboard";
    }


    @GetMapping(path="/{id}")
    public @ResponseBody Doctor getDoctor (@PathVariable(value = "id") Integer id)
            throws DoctorNotFoundException {
        Doctor s = doctorRepository.findById(id)
                .orElseThrow(() -> new DoctorNotFoundException());
        return s;
    }


//    @GetMapping(path="/all")
//    public @ResponseBody Iterable<Doctor> getAllDoctors() {
//        return DoctorRepository.findAll();
//    }


    @PostMapping("/create")
    public String createDoctor(@ModelAttribute Doctor s) {
        doctorRepository.save(s);
        return "redirect:dashboard";
    }


    @GetMapping(path="/{id}/edit")
    public String viewUpdateFormDoctor(@PathVariable(value = "id") Integer id,
                                       Model model) throws DoctorNotFoundException {
        model.addAttribute("doctor", this.getDoctor(id));
        return "doctor/edit";
    }


    @PutMapping("/{id}/update")
    public String updateDoctor(@ModelAttribute Doctor s) {
        doctorRepository.save(s);
        return "redirect:/doctor/dashboard";
    }


    @DeleteMapping("/delete")
    public String deleteDoctor(@ModelAttribute Doctor s) {
        doctorRepository.delete(s);
        return "redirect:dashboard";
    }
}



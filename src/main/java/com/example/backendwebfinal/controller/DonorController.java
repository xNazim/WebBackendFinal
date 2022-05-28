package com.example.backendwebfinal.controller;

import com.example.backendwebfinal.exception.DonorNotFoundException;

import com.example.backendwebfinal.model.Donor;
import com.example.backendwebfinal.repository.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/donor")
public class DonorController{

    @Autowired
    private DonorRepository donorRepository;


    @GetMapping("/dashboard")
    public String doctorIndex(Model model) {
        model.addAttribute("donor", new Donor());
        model.addAttribute("donors", donorRepository.findAll());
        return "donor/dashboard";
    }


    @GetMapping(path="/{id}")
    public @ResponseBody Donor getDonor (@PathVariable(value = "id") Integer id)
            throws DonorNotFoundException {
        Donor s = donorRepository.findById(id)
                .orElseThrow(() -> new DonorNotFoundException());
        return s;
    }


//    @GetMapping(path="/all")
//    public @ResponseBody Iterable<Doctor> getAllDoctors() {
//        return DoctorRepository.findAll();
//    }


    @PostMapping("/create")
    public String createDonor(@ModelAttribute Donor s) {
        donorRepository.save(s);
        return "redirect:dashboard";
    }


    @GetMapping(path="/{id}/edit")
    public String viewUpdateFormDonor(@PathVariable(value = "id") Integer id,
                                       Model model) throws DonorNotFoundException {
        model.addAttribute("donor", this.getDonor(id));
        return "donor/edit";
    }


    @PutMapping("/{id}/update")
    public String updateDonor(@ModelAttribute Donor s) {
        donorRepository.save(s);
        return "redirect:/donor/dashboard";
    }


    @DeleteMapping("/delete")
    public String deleteDonor(@ModelAttribute Donor s) {
        donorRepository.delete(s);
        return "redirect:dashboard";
    }
}
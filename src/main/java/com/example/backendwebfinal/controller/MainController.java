package com.example.backendwebfinal.controller;

import com.example.backendwebfinal.entity.Appointment;
import com.example.backendwebfinal.entity.Donor;
import com.example.backendwebfinal.entity.Laboratory;
import com.example.backendwebfinal.service.AppService;
import com.example.backendwebfinal.service.DonorService;
import com.example.backendwebfinal.service.LabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @Autowired
    private AppService appService;

    @Autowired
    private DonorService donorService;

    @Autowired
    private LabService labService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("appointment", new Appointment());
        model.addAttribute("donor", new Donor());
        model.addAttribute("laboratories", labService.getAllLabs());
        return "index";
    }



    @PostMapping("/")
    public String MakeApp(@ModelAttribute Appointment appointment) {
        appService.saveApp(appointment);
        return "index";
    }

    @PostMapping("/donation")
    public String MakeDonation(@ModelAttribute Donor donor) {
        donorService.saveDonor(donor);
        return "redirect:/";
    }




}

package com.example.backendwebfinal.service;

import com.example.backendwebfinal.entity.Appointment;
import com.example.backendwebfinal.entity.Donor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DonorService {
    List<Donor> getAllDonors();
    Donor saveDonor(Donor donor);
    Donor getDonorById(Integer id);
    Donor updateDonor(Donor donor);
    void deleteDonorById(Integer id);
}

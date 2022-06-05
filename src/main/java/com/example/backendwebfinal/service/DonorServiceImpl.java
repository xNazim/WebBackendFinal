package com.example.backendwebfinal.service;

import com.example.backendwebfinal.entity.Donor;
import com.example.backendwebfinal.repository.AppointmentRepository;
import com.example.backendwebfinal.repository.DonorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonorServiceImpl implements DonorService{

    private DonorRepository donorRepository;

    public DonorServiceImpl(DonorRepository donorRepository) {
        this.donorRepository = donorRepository;
    }

    @Override
    public List<Donor> getAllDonors() {
        return (List<Donor>) donorRepository.findAll();
    }

    @Override
    public Donor saveDonor(Donor donor) {
        return donorRepository.save(donor);
    }

    @Override
    public Donor getDonorById(Integer id) {
        return donorRepository.findById(id).get();
    }

    @Override
    public Donor updateDonor(Donor donor) {
        return donorRepository.save(donor);
    }

    @Override
    public void deleteDonorById(Integer id) {
    donorRepository.deleteById(id);
    }
}

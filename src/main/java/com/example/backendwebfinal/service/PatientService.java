package com.example.backendwebfinal.service;


import com.example.backendwebfinal.entity.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PatientService {
    List<Patient> getAllPatients();
    Patient savePatient(Patient patient);
    Patient getPatientById(Integer id);
    Patient updatePatient(Patient patient);
    void deletePatientById(Integer id);
}


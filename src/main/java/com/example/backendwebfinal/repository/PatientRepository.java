package com.example.backendwebfinal.repository;

import com.example.backendwebfinal.entity.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Integer> {
}

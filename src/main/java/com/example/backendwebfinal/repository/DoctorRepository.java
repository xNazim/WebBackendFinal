package com.example.backendwebfinal.repository;

import com.example.backendwebfinal.model.Doctor;
import com.example.backendwebfinal.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface DoctorRepository extends CrudRepository<Doctor, Integer> {

}
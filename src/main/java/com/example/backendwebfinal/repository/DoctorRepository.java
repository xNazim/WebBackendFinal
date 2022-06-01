package com.example.backendwebfinal.repository;

import com.example.backendwebfinal.entity.Doctor;
import org.springframework.data.repository.CrudRepository;

public interface DoctorRepository extends CrudRepository<Doctor, Integer> {

}
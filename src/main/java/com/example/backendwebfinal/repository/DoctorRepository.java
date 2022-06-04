package com.example.backendwebfinal.repository;

import com.example.backendwebfinal.entity.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Integer> {

}
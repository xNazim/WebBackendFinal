package com.example.backendwebfinal.repository;

import com.example.backendwebfinal.entity.Donor;
import org.springframework.data.repository.CrudRepository;

public interface DonorRepository extends CrudRepository<Donor, Integer> {
}

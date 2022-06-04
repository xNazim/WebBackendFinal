package com.example.backendwebfinal.repository;

import com.example.backendwebfinal.entity.Laboratory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaboratoryRepository extends CrudRepository<Laboratory, Integer> {
}

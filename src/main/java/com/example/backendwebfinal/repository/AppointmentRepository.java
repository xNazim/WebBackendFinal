package com.example.backendwebfinal.repository;

import com.example.backendwebfinal.entity.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {
}

package com.example.backendwebfinal.service;

import com.example.backendwebfinal.entity.Appointment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AppService {
    List<Appointment> getAllAppointments();
    Appointment saveApp(Appointment appointment);
    Appointment getAppById(Integer id);
    Appointment updateApp(Appointment appointment);
    void deleteAppById(Integer id);
}

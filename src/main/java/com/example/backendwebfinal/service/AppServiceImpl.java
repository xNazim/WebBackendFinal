package com.example.backendwebfinal.service;

import com.example.backendwebfinal.entity.Appointment;
import com.example.backendwebfinal.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppServiceImpl implements AppService {

    private AppointmentRepository appointmentRepository;

    public AppServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return (List<Appointment>) appointmentRepository.findAll();
    }

    @Override
    public Appointment saveApp(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment getAppById(Integer id) {
        return appointmentRepository.findById(id).get();
    }

    @Override
    public Appointment updateApp(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public void deleteAppById(Integer id) {
        appointmentRepository.deleteById(id);
    }
}

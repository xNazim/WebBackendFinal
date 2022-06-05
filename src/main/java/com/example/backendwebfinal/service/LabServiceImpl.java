package com.example.backendwebfinal.service;

import com.example.backendwebfinal.entity.Appointment;
import com.example.backendwebfinal.entity.Laboratory;
import com.example.backendwebfinal.repository.AppointmentRepository;
import com.example.backendwebfinal.repository.LaboratoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabServiceImpl implements LabService {

    private LaboratoryRepository laboratoryRepository;

    public LabServiceImpl(LaboratoryRepository laboratoryRepository) {
        this.laboratoryRepository = laboratoryRepository;
    }

    @Override
    public List<Laboratory> getAllLabs() {
        return (List<Laboratory>) laboratoryRepository.findAll();
    }

    @Override
    public Laboratory saveLab(Laboratory laboratory) {
        return laboratoryRepository.save(laboratory);
    }

    @Override
    public Laboratory getLabById(Integer id) {
        return laboratoryRepository.findById(id).get();
    }

    @Override
    public Laboratory updateLab(Laboratory laboratory) {
        return laboratoryRepository.save(laboratory);
    }

    @Override
    public void deleteLabById(Integer id) {
    laboratoryRepository.deleteById(id);
    }
}

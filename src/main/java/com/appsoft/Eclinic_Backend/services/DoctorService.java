package com.appsoft.Eclinic_Backend.services;

import com.appsoft.Eclinic_Backend.models.Doctor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface DoctorService {
    Doctor addDoctor(Doctor doctor);
    List<Doctor> getAllDoctors();
    Optional<Doctor> getDoctorById(Long id);
    Optional<Doctor> getDoctorByEmail(String email);
    void deleteDoctor(Long id);
}

package com.appsoft.Eclinic_Backend.serviceImpl;

import com.appsoft.Eclinic_Backend.Repo.DoctorRepository;
import com.appsoft.Eclinic_Backend.models.Doctor;
import com.appsoft.Eclinic_Backend.services.DoctorService;
import com.appsoft.Eclinic_Backend.utils.EmailService;
import com.appsoft.Eclinic_Backend.utils.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.appsoft.Eclinic_Backend.utils.PasswordUtil.generateRandomPassword;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmailService emailService;

    @Override
    public Doctor addDoctor(Doctor doctor) {
        String rawPassword;

        if (doctor.getPassword() == null || doctor.getPassword().isBlank()) {
            rawPassword = PasswordUtil.generateRandomPassword(10);
            doctor.setPassword(passwordEncoder.encode(rawPassword));
        } else {
            rawPassword = doctor.getPassword();
            doctor.setPassword(passwordEncoder.encode(rawPassword));
        }

        doctor.setRole("DOCTOR");

        Doctor savedDoctor = doctorRepository.save(doctor);

        emailService.sendPasswordToDoctor(doctor.getEmail(), doctor.getName(), rawPassword);

        return savedDoctor;
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Optional<Doctor> getDoctorById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Doctor> getDoctorByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public void deleteDoctor(Long id) {

    }
}

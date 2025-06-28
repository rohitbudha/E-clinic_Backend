package com.appsoft.Eclinic_Backend.Repo;


import com.appsoft.Eclinic_Backend.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Optional<Doctor> findByEmail(String email);
}

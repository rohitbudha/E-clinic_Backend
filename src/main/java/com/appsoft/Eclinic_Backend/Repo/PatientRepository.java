package com.appsoft.Eclinic_Backend.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appsoft.Eclinic_Backend.models.Patient;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findByEmail(String email);
    boolean existsByEmail(String email);
}

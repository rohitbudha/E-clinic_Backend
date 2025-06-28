package com.appsoft.Eclinic_Backend.services;

import java.util.List;

import com.appsoft.Eclinic_Backend.models.Patient;

public interface PatientService {
    Patient registerPatient(Patient patient);
    Patient getPatientById(Long id);
    List<Patient> getAllPatients();
    Patient updatePatient(Long id, Patient updatedPatient);
    void deletePatient(Long id);
}

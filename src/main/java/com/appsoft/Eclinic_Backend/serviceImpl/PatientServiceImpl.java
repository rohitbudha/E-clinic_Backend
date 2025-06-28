package com.appsoft.Eclinic_Backend.serviceImpl;

import java.util.List;

import com.appsoft.Eclinic_Backend.Repo.PatientRepository;
import com.appsoft.Eclinic_Backend.models.Patient;
import com.appsoft.Eclinic_Backend.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class PatientServiceImpl  implements PatientService{

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;
	private PasswordEncoder passwordEncoder;


	@Override
	public Patient registerPatient(Patient patient) {
		patient.setPassword(passwordEncoder.encode(patient.getPassword()));
		return patientRepository.save(patient);
	}

	@Override
	public Patient getPatientById(Long id) {
		return null;
	}

	@Override
	public List<Patient> getAllPatients() {
		return patientRepository.findAll();
	}

	@Override
	public Patient updatePatient(Long id, Patient updatedPatient) {
		return null;
	}

	@Override
	public void deletePatient(Long id) {

	}

}

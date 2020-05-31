package com.avikdigidev.covid.hms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.avikdigidev.covid.hms.model.Patient;
import com.datastax.driver.core.LocalDate;

@Service
public interface PatientService {
	public List<Patient> getAllpatients();

	public Optional<Patient> getPatientById(String patientId);

	public List<Patient> getPatientByAdmitDate(LocalDate dateOfAdmission);

	public Patient createPatient(Patient newPatient);

	public Optional<Patient> updatePatient(String patientId, Patient updatedPatient);

	public String deletePatient(String patientId);
}

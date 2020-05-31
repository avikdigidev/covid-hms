package com.avikdigidev.covid.hms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.avikdigidev.covid.hms.model.Patient;

@Service
public interface PatientService {
	public List<Patient> getAllpatients();

	public Optional<Patient> getPatientById(String patientId);
}

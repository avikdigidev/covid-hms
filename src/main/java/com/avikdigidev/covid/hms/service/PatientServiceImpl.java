package com.avikdigidev.covid.hms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.avikdigidev.covid.hms.model.Patient;
import com.avikdigidev.covid.hms.repository.PatientRepository;

@Service
@Component
public class PatientServiceImpl implements PatientService {
	@Autowired
	PatientRepository patientRepository;

	public List<Patient> getAllpatients() {
		Iterable<Patient> result = patientRepository.findAll();
		List<Patient> patientList = new ArrayList<Patient>();
		result.forEach(patientList::add);
		return patientList;

	}

	public Optional<Patient> getPatientById(String patientId) {
		Optional<Patient> patientData = patientRepository.getPatientById(patientId);
		return patientData;
	}
}

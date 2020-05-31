package com.avikdigidev.covid.hms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.avikdigidev.covid.hms.model.Patient;
import com.avikdigidev.covid.hms.repository.PatientRepository;
import com.datastax.driver.core.LocalDate;

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

	public List<Patient> getPatientByAdmitDate(LocalDate dateOfAdmission) {
		List<Patient> patientData = patientRepository.getPatientsByAdmitDate(dateOfAdmission);
		return patientData;
	}

	public Patient createPatient(Patient newPatient) {
		String patientId = String.valueOf(UUID.randomUUID());
		Patient patient = new Patient();
		BeanUtils.copyProperties(newPatient, patient);
		patient.setPatientId(patientId);
		patientRepository.save(patient);
		return patient;
	}

	public Optional<Patient> updatePatient(String patientId, Patient updatedPatient) {
		Optional<Patient> patientData = patientRepository.findById(patientId);
		if (patientData.isPresent()) {
			Patient patient = patientData.get();
			BeanUtils.copyProperties(updatedPatient, patient);
			patientRepository.save(patient);
			return patientData;
		} else {
			return null;
		}
	}

	public String deletePatient(String patientId) {
		Boolean result = patientRepository.existsById(patientId);
		patientRepository.deleteById(patientId);
		return "{ \"success\" : " + (result ? "true" : "false") + " }";
	}

}

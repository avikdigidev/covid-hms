package com.avikdigidev.covid.hms.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.avikdigidev.covid.hms.model.Patient;
import com.avikdigidev.covid.hms.repository.PatientRepository;
import com.avikdigidev.covid.hms.service.PatientService;
import com.datastax.driver.core.LocalDate;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class PatientController {

	@Autowired
	PatientRepository patientRepository;

	@Autowired
	PatientService patientService;

	@GetMapping("/patients")
	public List<Patient> getPatientList() {
		return patientService.getAllpatients();
	}

	@GetMapping("/patient/{patientId}")
	public Optional<Patient> getPatientById(@PathVariable String patientId) {
		return patientService.getPatientById(patientId);
	}

	@GetMapping("/patient/{dateOfAdmission}")
	public List<Patient> getPatientById(@PathVariable LocalDate dateOfAdmission) {
		List<Patient> patientData = patientRepository.getPatientsByAdmitDate(dateOfAdmission);
		return patientData;

	}

	@PostMapping("/patient")
	public Patient createPatient(@RequestBody Patient newPatient) {
		String patientId = String.valueOf(UUID.randomUUID());
		Patient patient = new Patient(patientId, newPatient.getFirstName(), newPatient.getLastName(),
				newPatient.getAge(), newPatient.getSex(), newPatient.getActiveStatus(), newPatient.getMobile(),
				newPatient.getLandmark(), newPatient.getCity(), newPatient.getState(), newPatient.getDistrict(),
				newPatient.getCountry(), newPatient.getPincode(), newPatient.getDateOfBirth(),
				newPatient.getDateOfDeath(), newPatient.getDateOfAdmission(), newPatient.getDateOfDischarge());
		patientRepository.save(patient);
		return patient;
	}

	@PutMapping("/patient/{patientId}")
	public Optional<Patient> updatePatient(@PathVariable String patientId, @RequestBody Patient updatedPatient) {
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

	@DeleteMapping(value = "/patient/{patientId}")
	public String deletePatient(@PathVariable String patientId) {
		Boolean result = patientRepository.existsById(patientId);
		patientRepository.deleteById(patientId);
		return "{ \"success\" : " + (result ? "true" : "false") + " }";
	}

}

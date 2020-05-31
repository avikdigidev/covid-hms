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
		return patientService.getPatientByAdmitDate(dateOfAdmission);
	}

	@PostMapping("/patient")
	public Patient createPatient(@RequestBody Patient newPatient) {
		return patientService.createPatient(newPatient);
	}

	@PutMapping("/update/{patientId}")
	public Optional<Patient> updatePatient(@PathVariable String patientId, @RequestBody Patient updatedPatient) {
		return patientService.updatePatient(patientId, updatedPatient);
	}

	@DeleteMapping(value = "/delete/{patientId}")
	public String deletePatient(@PathVariable String patientId) {
		return patientService.deletePatient(patientId);
	}

}

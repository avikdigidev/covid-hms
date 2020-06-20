package com.avikdigidev.covid.hms.controller;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.avikdigidev.covid.hms.domain.request.PatientRequest;
import com.avikdigidev.covid.hms.domain.response.PatientResponse;
import com.avikdigidev.covid.hms.model.Patient;
import com.avikdigidev.covid.hms.repository.PatientRepository;
import com.avikdigidev.covid.hms.service.PatientService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class PatientController {

	@Autowired
	PatientRepository patientRepository;

	@Autowired
	PatientService patientService;

	@GetMapping("/patients")
	public List<PatientResponse> getPatientList() {
		return patientService.getAllpatients();
	}

	@PostMapping("/getPatient/")
	public PatientResponse getPatientById(@RequestBody PatientRequest patientRequest) {
		String patientId = patientRequest.getPatientId();
		return patientService.getPatientById(patientId);
	}

	@PostMapping("/getPatientByAdmitDate")
	public List<PatientResponse> getPatientByAdmitDate(@RequestBody PatientRequest patientRequest) {
		Date dateOfAdmission = patientRequest.getDateOfAdmission();
		return patientService.getPatientByAdmitDate(dateOfAdmission);
	}

	@PostMapping("/addPatient")
	public String createPatient(@RequestBody PatientRequest patientRequest) {
		return patientService.createPatient(patientRequest);
	}

	@PostMapping("/updateInPatient")
	public String updateInPatient(@RequestBody PatientRequest patientRequest) {
		return patientService.updateInPatient(patientRequest);
	}
	
	@PostMapping("/updateInClinic")
	public String updateInClinic(@RequestBody PatientRequest patientRequest) {
		return patientService.updateInClinic(patientRequest);
	}

	@PostMapping("/deletePatientById")
	public String deletePatient(@RequestBody PatientRequest patientRequest) {
		String patientId = patientRequest.getPatientId();
		return patientService.deletePatient(patientId);
	}

}

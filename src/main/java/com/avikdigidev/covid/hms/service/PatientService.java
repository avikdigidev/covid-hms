package com.avikdigidev.covid.hms.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.avikdigidev.covid.hms.domain.request.PatientRequest;
import com.avikdigidev.covid.hms.domain.response.PatientResponse;
import com.avikdigidev.covid.hms.model.Patient;

@Service
public interface PatientService {
	public List<Patient> getAllpatients();

	public PatientResponse getPatientById(String patientId);

	public List<PatientResponse> getPatientByAdmitDate(Date dateOfAdmission);

	public String createPatient(PatientRequest patientRequest);

	public String updatePatient(PatientRequest patientRequest);

	public String deletePatient(String patientId);
}

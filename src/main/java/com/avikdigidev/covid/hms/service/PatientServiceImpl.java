package com.avikdigidev.covid.hms.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.avikdigidev.covid.hms.domain.request.PatientRequest;
import com.avikdigidev.covid.hms.domain.response.PatientResponse;
import com.avikdigidev.covid.hms.model.Patient;
import com.avikdigidev.covid.hms.repository.PatientRepository;
import com.datastax.driver.core.LocalDate;

@Service
@Component
public class PatientServiceImpl implements PatientService {
	@Autowired
	PatientRepository patientRepository;

	public List<Patient> getAllpatients() {
		List<Patient> patientList = patientRepository.getAllPatient();
		return patientList;
	}

	public PatientResponse getPatientById(String patientId) {
		Patient patient = patientRepository.getPatientById(patientId);
		PatientResponse patientResponse = new PatientResponse();
		BeanUtils.copyProperties(patient, patientResponse);
		convertDateForResponse(patient, patientResponse);
		return patientResponse;
	}

	public List<PatientResponse> getPatientByAdmitDate(Date dateOfAdmission) {
		LocalDate ld = sqlToLocal(dateOfAdmission);
		List<Patient> patientData = patientRepository.getPatientsByAdmitDate(ld);
		return createPatientResponseList(patientData);
	}

	public String createPatient(PatientRequest patientRequest) {
		String patientId = String.valueOf(UUID.randomUUID());
		Patient patient = new Patient();
		BeanUtils.copyProperties(patientRequest, patient);
		patient.setPatientId(patientId);
		convertDateForAdding(patientRequest, patient);
		patientRepository.save(patient);
		return "Patient Added Successfully with PaitentId: " + patientId;
	}

	public String updatePatient(PatientRequest patientRequest) {
		String patientId = patientRequest.getPatientId();
		Patient patientData = patientRepository.getPatientById(patientId);
		if (patientData != null) {
			BeanUtils.copyProperties(patientRequest, patientData);
			convertDateForAdding(patientRequest, patientData);
			patientRepository.save(patientData);
			return "Patient Record Updated Successfully";
		} else {
			return "Patient Record Not Updated or doesn't exist";
		}
	}

	public String deletePatient(String patientId) {

		Patient patient = patientRepository.getPatientById(patientId);
		if (patient != null) {
			patientRepository.deletePatientById(patientId);
			return "Patients Record Deleted Successfully";
		} else {
			return "Patients Record not found";
		}

	}

	// ---------------------------------------UTILITY METHODS------------------------------------------------------//
	public java.time.LocalDate cassandraLdToJavaLd(com.datastax.driver.core.LocalDate ld) {
		if (ld == null) {
			return null;
		} else {
			return java.time.LocalDate.of(ld.getYear(), ld.getMonth(), ld.getDay());
		}
	}

	private LocalDate sqlToLocal(Date date) {
		return LocalDate.fromYearMonthDay(date.toLocalDate().getYear(), date.toLocalDate().getMonthValue(),
				date.toLocalDate().getDayOfMonth());
	}

	public void convertDateForAdding(PatientRequest patientRequest, Patient patient) {
		patient.setDateOfAdmission(sqlToLocal(patientRequest.getDateOfAdmission()));
		patient.setDateOfBirth(sqlToLocal(patientRequest.getDateOfBirth()));
		patient.setDateOfDeath(sqlToLocal(patientRequest.getDateOfDeath()));
		patient.setDateOfDischarge(sqlToLocal(patientRequest.getDateOfDischarge()));
		patient.setDateOfFirstTestResult(sqlToLocal(patientRequest.getDateOfFirstTestResult()));
		patient.setDateOfSecondTestResult(sqlToLocal(patientRequest.getDateOfSecondTestResult()));
		patient.setDateOfThirdTestResult(sqlToLocal(patientRequest.getDateOfThirdTestResult()));
	}

	public void convertDateForResponse(Patient patient, PatientResponse patientResponse) {
		patientResponse.setDateOfAdmission(cassandraLdToJavaLd(patient.getDateOfAdmission()));
		patientResponse.setDateOfBirth(cassandraLdToJavaLd(patient.getDateOfBirth()));
		patientResponse.setDateOfDeath(cassandraLdToJavaLd(patient.getDateOfDeath()));
		patientResponse.setDateOfDischarge(cassandraLdToJavaLd(patient.getDateOfDischarge()));
		patientResponse.setDateOfFirstTestResult(cassandraLdToJavaLd(patient.getDateOfFirstTestResult()));
		patientResponse.setDateOfSecondTestResult(cassandraLdToJavaLd(patient.getDateOfSecondTestResult()));
		patientResponse.setDateOfThirdTestResult(cassandraLdToJavaLd(patient.getDateOfThirdTestResult()));
	}

	private List<PatientResponse> createPatientResponseList(List<Patient> patientData) {
		List<PatientResponse> patientResponseList = new ArrayList<>();
		for (Patient patient : patientData) {
			PatientResponse patientResponse = new PatientResponse();
			BeanUtils.copyProperties(patient, patientResponse);
			convertDateForResponse(patient, patientResponse);
			patientResponseList.add(patientResponse);
		}
		return patientResponseList;
	}
}

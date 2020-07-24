package com.avikdigidev.covid.hms.service;

import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
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

	public List<PatientResponse> getAllpatients() {
		List<Patient> patientList = patientRepository.getAllPatient();
		// return patientList;
		return createPatientResponseList(patientList);
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
		String patientId = String.valueOf(getCountofPatients() + 1);
		System.out.println(patientId);
		// String patientId = String.valueOf(UUID.randomUUID());
		Patient patient = new Patient();
		stringToBooleanCoverter(patientRequest, patient);
		BeanUtils.copyProperties(patientRequest, patient);
		patient.setPatientId(patientId);
		Date date = new Date(System.currentTimeMillis());
		patientRequest.setDateOfAdmission(date);
		String dailyPatientCounter = String.valueOf(getCountOfPatientsOnSingleDay(sqlToLocal(date)));
		patient.setDailyPatientCounter(dailyPatientCounter);
		System.out.println(dailyPatientCounter);
		convertDateForAdding(patientRequest, patient);
		stringToBooleanCoverter(patientRequest, patient);
		patient.setSymptomStatus(patientRequest.getSymptomStatus());
		patient.setActionTaken(patientRequest.getActionTaken());
		patient.setComment(patientRequest.getComment());
		Instant lastUpdatedOn = Instant.now();
		patient.setLastUpdatedOn(lastUpdatedOn);
		patientRepository.save(patient);
		return "Patient Added Successfully with PaitentId: " + patientId;
	}

	public String updateInPatient(PatientRequest patientRequest) {
		String patientId = patientRequest.getPatientId();
		Patient patientData = patientRepository.getPatientById(patientId);
		if (patientData != null) {
			patientData.setBedAllotment(patientRequest.getBedAllotment());
			patientData.setOutcome(patientRequest.getOutcome());
			patientData.setFirstResult(patientRequest.getFirstResult());
			patientData.setSecondResult(patientRequest.getSecondResult());
			patientData.setThirdResult(patientRequest.getThirdResult());
			convertDateForAdding(patientRequest, patientData);
			patientRepository.save(patientData);
			return "In-Patient Record Updated Successfully";
		} else {
			return "In-Patient Record Not Updated or doesn't exist";
		}
	}

	public String updateInClinic(PatientRequest patientRequest) {
		String patientId = patientRequest.getPatientId();
		Patient patientData = patientRepository.getPatientById(patientId);
		if (patientData != null) {
			stringToBooleanCoverter(patientRequest, patientData);
			patientData.setSymptomStatus(patientRequest.getSymptomStatus());
			patientData.setActionTaken(patientRequest.getActionTaken());
			patientData.setComment(patientRequest.getComment());
			patientRepository.save(patientData);
			return "Patient Clinic Record Updated Successfully";
		} else {
			return "Patient Clinic Record Not Updated or doesn't exist";
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

	// ---------------------------------------UTILITY
	// METHODS------------------------------------------------------//

	private int getCountofPatients() {
		return patientRepository.getTotalPatients();

	}

	private int getCountOfPatientsOnSingleDay(LocalDate admittedon) {
		if 	(patientRepository.getTotalPatientsByDay(admittedon) == 0) {
			return 1;
		} 
		else
			return patientRepository.getTotalPatientsByDay(admittedon)+1;

	}

	public java.time.LocalDate cassandraLdToJavaLd(com.datastax.driver.core.LocalDate ld) {
		if (ld == null) {
			return null;
		} else {
			return java.time.LocalDate.of(ld.getYear(), ld.getMonth(), ld.getDay());
		}
	}

	private LocalDate sqlToLocal(Date date) {
		if (date == null) {
			return null;
		} else {
			return LocalDate.fromYearMonthDay(date.toLocalDate().getYear(), date.toLocalDate().getMonthValue(),
					date.toLocalDate().getDayOfMonth());
		}
	}

	public void convertDateForAdding(PatientRequest patientRequest, Patient patient) {

		patient.setDateOfAdmission(sqlToLocal(patientRequest.getDateOfAdmission()));
		patient.setDateOfDischarge(sqlToLocal(patientRequest.getDateOfDischarge()));
		patient.setDateOfFirstTest(sqlToLocal(patientRequest.getDateOfFirstTest()));
		patient.setDateOfSecondTest(sqlToLocal(patientRequest.getDateOfSecondTest()));
		patient.setDateOfThirdTest(sqlToLocal(patientRequest.getDateOfThirdTest()));
		patient.setDateOfFirstTestResult(sqlToLocal(patientRequest.getDateOfFirstTestResult()));
		patient.setDateOfSecondTestResult(sqlToLocal(patientRequest.getDateOfSecondTestResult()));
		patient.setDateOfThirdTestResult(sqlToLocal(patientRequest.getDateOfThirdTestResult()));
	}

	public void convertDateForResponse(Patient patient, PatientResponse patientResponse) {
		patientResponse.setDateOfAdmission(cassandraLdToJavaLd(patient.getDateOfAdmission()));
		patientResponse.setDateOfDischarge(cassandraLdToJavaLd(patient.getDateOfDischarge()));
		patientResponse.setDateOfFirstTest(cassandraLdToJavaLd(patient.getDateOfFirstTest()));
		patientResponse.setDateOfSecondTest(cassandraLdToJavaLd(patient.getDateOfSecondTest()));
		patientResponse.setDateOfThirdTest(cassandraLdToJavaLd(patient.getDateOfThirdTest()));
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

	private void stringToBooleanCoverter(PatientRequest patientRequest, Patient patient) {
		if (patientRequest.getTravelHistory() == null) {
			patient.setTravelHistory(null);
		} else if (patientRequest.getTravelHistory().equals("Yes")) {
			patient.setTravelHistory(true);
		} else if (patientRequest.getTravelHistory().equals("No")) {
			patient.setTravelHistory(false);
		}

		if (patientRequest.getContactHistory() == null) {
			patient.setContactHistory(null);
		} else if (patientRequest.getContactHistory().equals("Yes")) {
			patient.setContactHistory(true);
		} else if (patientRequest.getContactHistory().equals("No")) {
			patient.setContactHistory(false);
		}

		if (patientRequest.getCoMorbidity() == null) {
			patient.setCoMorbidity(null);
		} else if (patientRequest.getCoMorbidity().equals("Yes")) {
			patient.setCoMorbidity(true);
		} else if (patientRequest.getCoMorbidity().equals("No")) {
			patient.setCoMorbidity(false);
		}

		if (patientRequest.getCovidActiveStatus() == null) {
			patient.setCovidActiveStatus(null);
		} else if (patientRequest.getCovidActiveStatus().equals("Suspected")) {
			patient.setCovidActiveStatus(true);
		} else if (patientRequest.getCovidActiveStatus().equals("NonSuspected")) {
			patient.setCovidActiveStatus(false);
		}

		if (patientRequest.getSrfNo() == null) {
			patient.setSrfNo(null);
		} else if (patientRequest.getSrfNo().equals("Yes")) {
			patient.setSrfNo(true);
		} else if (patientRequest.getSrfNo().equals("No")) {
			patient.setSrfNo(false);
		}

	}


}

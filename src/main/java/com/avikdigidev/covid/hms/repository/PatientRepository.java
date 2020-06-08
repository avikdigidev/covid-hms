package com.avikdigidev.covid.hms.repository;


import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import com.avikdigidev.covid.hms.model.Patient;
import com.avikdigidev.covid.hms.utils.HMSConstants;
import com.datastax.driver.core.LocalDate;

public interface PatientRepository extends CassandraRepository<Patient, String> {
	@Query(HMSConstants.ALL_PATIENT_QUERY)
	List<Patient> getAllPatient();
	
	@Query(HMSConstants.SINGLE_PATIENT_QUERY)
	Patient getPatientById(String patientId);

	@Query(HMSConstants.SINGLE_DAY_QUERY)
	List<Patient> getPatientsByAdmitDate(LocalDate dateOfAdmission);
	
	
	@Query(HMSConstants.DELETE_PATIENT_QUERY)
	void deletePatientById(String patientId);
}

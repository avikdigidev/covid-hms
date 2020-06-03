package com.avikdigidev.covid.hms.service.test;

import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.test.util.ReflectionTestUtils;

import com.avikdigidev.covid.hms.model.Patient;
import com.avikdigidev.covid.hms.repository.PatientRepository;
import com.avikdigidev.covid.hms.service.PatientServiceImpl;
import com.datastax.driver.core.LocalDate;

@Service
@Component
public class PatientServiceImplTest {

	@Mock
	Environment env;

	@Mock
	private PatientRepository patientRepository;

	@InjectMocks
	PatientServiceImpl patientServiceImpl;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this); // without this you will get NPE

	}

	private LocalDate sqlToLocal(Date date) {
		return LocalDate.fromYearMonthDay(date.toLocalDate().getYear(), date.toLocalDate().getMonthValue(),
				date.toLocalDate().getDayOfMonth());
	}

	@Test
	public void getAllpatientsTest() {

		List<Patient> patientList = new ArrayList<Patient>();
		Patient patient = new Patient();

		String patientId = "unique idsrt sryvb56usegvvyv";
		patient.setPatientId(patientId);
		patient.setDateOfAdmission(sqlToLocal(new Date(System.currentTimeMillis())));
		patientList.add(patient);
		when(patientRepository.getAllPatient()).thenReturn(patientList);
		patientServiceImpl.getAllpatients();
	}

}

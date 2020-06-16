package com.avikdigidev.covid.hms.model;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import com.datastax.driver.core.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table("patientdetails")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Patient {

	@PrimaryKeyColumn(name = "patientid", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
	private String patientId;

	@Column(value = "firstname")
	private String firstName;

	@Column(value = "lastname")
	private String lastName;

	@Column(value = "age")
	private int age;

	@Column(value = "sex")
	private String sex;

	@Column(value = "covidactivestatus")
	private Boolean covidActiveStatus;

	@Column(value = "mobilenumber")
	private String mobile;

	@Column(value = "landmark")
	private String landmark;

	@Column(value = "city")
	private String city;

	@Column(value = "state")
	private String state;

	@Column(value = "district")
	private String district;

	@Column(value = "country")
	private String country;

	@Column(value = "pincode")
	private int pincode;

	@Column(value = "dob")
	private LocalDate dateOfBirth;

	@Column(value = "dod")
	private LocalDate dateOfDeath;

	@Column(value = "admittedon")
	private LocalDate dateOfAdmission;

	@Column(value = "dischargedon")
	private LocalDate dateOfDischarge;

	@Column(value = "travelhistory")
	private Boolean travelHistory;

	@Column(value = "contacthistory")
	private Boolean contactHistory;

	@Column(value = "comorbidity")
	private Boolean coMorbidity;
	// list of selected outcomes -dropdown menu
	@Column(value = "symptomstatus")
	private String symptomStatus;
	// list of selected outcomes -dropdown menu
	@Column(value = "actiontaken")
	private String actionTaken;

	@Column(value = "bedallotment")
	private String bedAllotment;
	// list of selected outcomes -dropdown menu
	@Column(value = "outcome")
	private String outcome;
	
	@Column(value = "dateoffirsttest")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dateOfFirstTest;

	@Column(value = "dateofsecondtest")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dateOfSecondTest;

	@Column(value = "dateofthirdtest")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dateOfThirdTest;

	@Column(value = "dateoffirstresult")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dateOfFirstTestResult;

	@Column(value = "dateofsecondresult")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dateOfSecondTestResult;

	@Column(value = "dateofthirdresult")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dateOfThirdTestResult;
	
	// list of selected outcomes -dropdown menu
	@Column(value = "firstresult")
	private String firstResult;
	
	// list of selected outcomes -dropdown menu
	@Column(value = "secondresult")
	private String secondResult;
	
	// list of selected outcomes -dropdown menu
	@Column(value = "thirdresult")
	private String thirdResult;

	// additional comment
	@Column(value = "comment")
	private String comment;

}

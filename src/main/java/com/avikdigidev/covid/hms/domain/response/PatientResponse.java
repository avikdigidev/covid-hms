package com.avikdigidev.covid.hms.domain.response;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@Getter
@Setter
@ToString
@NoArgsConstructor

public class PatientResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("patientid")
	private String patientId;

	@JsonProperty("firstname")
	private String firstName;

	@JsonProperty("lastname")
	private String lastName;

	@JsonProperty("age")
	private int age;

	@JsonProperty("sex")
	private String sex;

	@JsonProperty("covidactivestatus")
	private Boolean covidActiveStatus;

	@JsonProperty("mobilenumber")
	private String mobile;

	@JsonProperty("landmark")
	private String landmark;

	@JsonProperty("city")
	private String city;

	@JsonProperty("state")
	private String state;

	@JsonProperty("district")
	private String district;

	@JsonProperty("country")
	private String country;

	@JsonProperty("pincode")
	private int pincode;

	@JsonProperty("dob")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dateOfBirth;

	@JsonProperty("dod")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dateOfDeath;

	@JsonProperty("admittedon")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfAdmission;

	@JsonProperty("dischargedon")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dateOfDischarge;

	@JsonProperty("travelhistory")
	private Boolean travelHistory;

	@JsonProperty("contacthistory")
	private Boolean contactHistory;

	@JsonProperty("comorbidity")
	private Boolean coMorbidity;

	// list of selected outcomes -dropdown menu
	@JsonProperty("symptomstatus")
	private String symptomStatus;
	// list of selected outcomes -dropdown menu
	@JsonProperty("actiontaken")
	private String actionTaken;

	@JsonProperty("bedallotment")
	private String bedAllotment;
	// list of selected outcomes -dropdown menu
	@JsonProperty("outcome")
	private String outcome;

	@JsonProperty("dateoffirstresult")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dateOfFirstTestResult;
	// list of selected outcomes -dropdown menu
	@JsonProperty("firstresult")
	private String firstResult;

	@JsonProperty("dateofsecondresult")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dateOfSecondTestResult;

	// list of selected outcomes -dropdown menu
	@JsonProperty("secondresult")
	private String secondResult;

	@JsonProperty("dateofthirdresult")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dateOfThirdTestResult;
	// list of selected outcomes -dropdown menu
	@JsonProperty("thirdresult")
	private String thirdResult;

	// additional comment
	@JsonProperty("comment")
	private String comment;

}

package com.avikdigidev.covid.hms.domain.request;

import java.sql.Date;
import java.time.Instant;

import org.springframework.data.cassandra.core.mapping.Column;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
public class PatientRequest {

	private static final long serialVersionUID = 1L;

	@JsonProperty("patientid")
	private String patientId;

	@JsonProperty("name")
	private String name;

	@JsonProperty("age")
	private int age;

	@JsonProperty("sex")
	private String sex;

	@JsonProperty("covidactivestatus")
	private String covidActiveStatus;

	@JsonProperty("mobilenumber")
	private String mobile;


	@JsonProperty("city")
	private String city;


	@JsonProperty("district")
	private String district;


	@JsonProperty("admittedon")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dateOfAdmission;

	@JsonProperty("dischargedon")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateOfDischarge;

	@JsonProperty("travelhistory")
	private String travelHistory;

	@JsonProperty("contacthistory")
	private String contactHistory;

	@JsonProperty("comorbidity")
	private String coMorbidity;

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

	@JsonProperty("dateoffirst")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateOfFirstTest;
	
	@JsonProperty("dateofsecondtest")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateOfSecondTest;
	
	@JsonProperty("dateofthirdtest")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateOfThirdTest;
	
	@JsonProperty("dateoffirstresult")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateOfFirstTestResult;
	// list of selected outcomes -dropdown menu
	@JsonProperty("firstresult")
	private String firstResult;

	@JsonProperty("dateofsecondresult")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateOfSecondTestResult;

	// list of selected outcomes -dropdown menu
	@JsonProperty("secondresult")
	private String secondResult;

	@JsonProperty("dateofthirdresult")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateOfThirdTestResult;
	
	// list of selected outcomes -dropdown menu
	@JsonProperty("thirdresult")
	private String thirdResult;

	// additional comment
	@JsonProperty("comment")
	private String comment;
	
	@JsonProperty("srfno")
	private String srfNo;

	
	@JsonProperty("lastupdatedon")
	private Instant lastUpdatedOn;

	
}
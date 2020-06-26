package com.avikdigidev.covid.hms.domain.response;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.data.cassandra.core.mapping.Column;
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

	@JsonProperty("dateoffirsttest")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dateOfFirstTest;

	@JsonProperty("dateofsecondtest")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dateOfSecondTest;

	@JsonProperty("dateofthirdtest")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dateOfThirdTest;
	
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

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Boolean getCovidActiveStatus() {
		return covidActiveStatus;
	}

	public void setCovidActiveStatus(Boolean covidActiveStatus) {
		this.covidActiveStatus = covidActiveStatus;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public LocalDate getDateOfDeath() {
		return dateOfDeath;
	}

	public void setDateOfDeath(LocalDate dateOfDeath) {
		this.dateOfDeath = dateOfDeath;
	}

	public LocalDate getDateOfAdmission() {
		return dateOfAdmission;
	}

	public void setDateOfAdmission(LocalDate dateOfAdmission) {
		this.dateOfAdmission = dateOfAdmission;
	}

	public LocalDate getDateOfDischarge() {
		return dateOfDischarge;
	}

	public void setDateOfDischarge(LocalDate dateOfDischarge) {
		this.dateOfDischarge = dateOfDischarge;
	}

	public Boolean getTravelHistory() {
		return travelHistory;
	}

	public void setTravelHistory(Boolean travelHistory) {
		this.travelHistory = travelHistory;
	}

	public Boolean getContactHistory() {
		return contactHistory;
	}

	public void setContactHistory(Boolean contactHistory) {
		this.contactHistory = contactHistory;
	}

	public Boolean getCoMorbidity() {
		return coMorbidity;
	}

	public void setCoMorbidity(Boolean coMorbidity) {
		this.coMorbidity = coMorbidity;
	}

	public String getSymptomStatus() {
		return symptomStatus;
	}

	public void setSymptomStatus(String symptomStatus) {
		this.symptomStatus = symptomStatus;
	}

	public String getActionTaken() {
		return actionTaken;
	}

	public void setActionTaken(String actionTaken) {
		this.actionTaken = actionTaken;
	}

	public String getBedAllotment() {
		return bedAllotment;
	}

	public void setBedAllotment(String bedAllotment) {
		this.bedAllotment = bedAllotment;
	}

	public String getOutcome() {
		return outcome;
	}

	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}

	public LocalDate getDateOfFirstTest() {
		return dateOfFirstTest;
	}

	public void setDateOfFirstTest(LocalDate dateOfFirstTest) {
		this.dateOfFirstTest = dateOfFirstTest;
	}

	public LocalDate getDateOfSecondTest() {
		return dateOfSecondTest;
	}

	public void setDateOfSecondTest(LocalDate dateOfSecondTest) {
		this.dateOfSecondTest = dateOfSecondTest;
	}

	public LocalDate getDateOfThirdTest() {
		return dateOfThirdTest;
	}

	public void setDateOfThirdTest(LocalDate dateOfThirdTest) {
		this.dateOfThirdTest = dateOfThirdTest;
	}

	public LocalDate getDateOfFirstTestResult() {
		return dateOfFirstTestResult;
	}

	public void setDateOfFirstTestResult(LocalDate dateOfFirstTestResult) {
		this.dateOfFirstTestResult = dateOfFirstTestResult;
	}

	public String getFirstResult() {
		return firstResult;
	}

	public void setFirstResult(String firstResult) {
		this.firstResult = firstResult;
	}

	public LocalDate getDateOfSecondTestResult() {
		return dateOfSecondTestResult;
	}

	public void setDateOfSecondTestResult(LocalDate dateOfSecondTestResult) {
		this.dateOfSecondTestResult = dateOfSecondTestResult;
	}

	public String getSecondResult() {
		return secondResult;
	}

	public void setSecondResult(String secondResult) {
		this.secondResult = secondResult;
	}

	public LocalDate getDateOfThirdTestResult() {
		return dateOfThirdTestResult;
	}

	public void setDateOfThirdTestResult(LocalDate dateOfThirdTestResult) {
		this.dateOfThirdTestResult = dateOfThirdTestResult;
	}

	public String getThirdResult() {
		return thirdResult;
	}

	public void setThirdResult(String thirdResult) {
		this.thirdResult = thirdResult;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}

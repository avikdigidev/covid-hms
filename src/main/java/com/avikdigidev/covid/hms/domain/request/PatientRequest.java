package com.avikdigidev.covid.hms.domain.request;

import java.sql.Date;

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

	@JsonProperty("firstname")
	private String firstName;

	@JsonProperty("lastname")
	private String lastName;

	@JsonProperty("age")
	private int age;

	@JsonProperty("sex")
	private String sex;

	@JsonProperty("covidactivestatus")
	private String covidActiveStatus;

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
	private Date dateOfBirth;

	@JsonProperty("dod")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateOfDeath;

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

	public String getCovidActiveStatus() {
		return covidActiveStatus;
	}

	public void setCovidActiveStatus(String covidActiveStatus) {
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getDateOfDeath() {
		return dateOfDeath;
	}

	public void setDateOfDeath(Date dateOfDeath) {
		this.dateOfDeath = dateOfDeath;
	}

	public Date getDateOfAdmission() {
		return dateOfAdmission;
	}

	public void setDateOfAdmission(Date dateOfAdmission) {
		this.dateOfAdmission = dateOfAdmission;
	}

	public Date getDateOfDischarge() {
		return dateOfDischarge;
	}

	public void setDateOfDischarge(Date dateOfDischarge) {
		this.dateOfDischarge = dateOfDischarge;
	}

	public String getTravelHistory() {
		return travelHistory;
	}

	public void setTravelHistory(String travelHistory) {
		this.travelHistory = travelHistory;
	}

	public String getContactHistory() {
		return contactHistory;
	}

	public void setContactHistory(String contactHistory) {
		this.contactHistory = contactHistory;
	}

	public String getCoMorbidity() {
		return coMorbidity;
	}

	public void setCoMorbidity(String coMorbidity) {
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

	public Date getDateOfFirstTest() {
		return dateOfFirstTest;
	}

	public void setDateOfFirstTest(Date dateOfFirstTest) {
		this.dateOfFirstTest = dateOfFirstTest;
	}

	public Date getDateOfSecondTest() {
		return dateOfSecondTest;
	}

	public void setDateOfSecondTest(Date dateOfSecondTest) {
		this.dateOfSecondTest = dateOfSecondTest;
	}

	public Date getDateOfThirdTest() {
		return dateOfThirdTest;
	}

	public void setDateOfThirdTest(Date dateOfThirdTest) {
		this.dateOfThirdTest = dateOfThirdTest;
	}

	public Date getDateOfFirstTestResult() {
		return dateOfFirstTestResult;
	}

	public void setDateOfFirstTestResult(Date dateOfFirstTestResult) {
		this.dateOfFirstTestResult = dateOfFirstTestResult;
	}

	public String getFirstResult() {
		return firstResult;
	}

	public void setFirstResult(String firstResult) {
		this.firstResult = firstResult;
	}

	public Date getDateOfSecondTestResult() {
		return dateOfSecondTestResult;
	}

	public void setDateOfSecondTestResult(Date dateOfSecondTestResult) {
		this.dateOfSecondTestResult = dateOfSecondTestResult;
	}

	public String getSecondResult() {
		return secondResult;
	}

	public void setSecondResult(String secondResult) {
		this.secondResult = secondResult;
	}

	public Date getDateOfThirdTestResult() {
		return dateOfThirdTestResult;
	}

	public void setDateOfThirdTestResult(Date dateOfThirdTestResult) {
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
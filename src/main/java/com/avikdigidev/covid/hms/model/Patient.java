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

	public LocalDate getDateOfSecondTestResult() {
		return dateOfSecondTestResult;
	}

	public void setDateOfSecondTestResult(LocalDate dateOfSecondTestResult) {
		this.dateOfSecondTestResult = dateOfSecondTestResult;
	}

	public LocalDate getDateOfThirdTestResult() {
		return dateOfThirdTestResult;
	}

	public void setDateOfThirdTestResult(LocalDate dateOfThirdTestResult) {
		this.dateOfThirdTestResult = dateOfThirdTestResult;
	}

	public String getFirstResult() {
		return firstResult;
	}

	public void setFirstResult(String firstResult) {
		this.firstResult = firstResult;
	}

	public String getSecondResult() {
		return secondResult;
	}

	public void setSecondResult(String secondResult) {
		this.secondResult = secondResult;
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

	
}

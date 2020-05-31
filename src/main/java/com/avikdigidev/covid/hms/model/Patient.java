package com.avikdigidev.covid.hms.model;

import java.time.LocalDate;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

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

	@Column(value = "active")
	private Boolean activeStatus;

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

	@PrimaryKeyColumn(name = "admittedon", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
	private LocalDate dateOfAdmission;

	@Column(value = "dischargedon")
	private LocalDate dateOfDischarge;

}

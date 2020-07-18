package com.avikdigidev.covid.hms.utils;

public class HMSConstants {

	public static final String SINGLE_PATIENT_QUERY = "select * from patientdetails where patientid = ?0;";
	public static final String SINGLE_DAY_QUERY ="select * from patientdetails where admittedon =?0 Allow filtering;";
	public static final String SINGLE_PATIENT_COUNT_QUERY ="select count(*) from patientdetails where admittedon = ?0 ALLOW FILTERING;";
	public static final String ALL_PATIENT_QUERY = "select * from patientdetails;";
	public static final String DELETE_PATIENT_QUERY ="delete from patientdetails WHERE patientid = ?0;";
	public static final String PATIENT_COUNT_QUERY = "select count(*) from patientdetails;";
}

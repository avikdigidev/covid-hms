package com.avikdigidev.covid.hms.utils;

public class HMSConstants {

	public static final String SINGLE_PATIENT_QUERY = "select * from patientdetails where patientid = ?0;";
	public static final String SINGLE_DAY_QUERY ="select * from patientdetails where admittedon = '?0' Allow filtering;";
	public static final String ALL_PATIENT_QUERY = "select * from patientdetails;";

}

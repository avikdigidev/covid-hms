Cassandra DB:
create keyspace covid_hms with replication={'class':'SimpleStrategy', 'replication_factor':1};

CREATE TABLE covid_hms.patientdetails (
	patientid text,
	admittedon date,
	actiontaken text,
	covidactivestatus boolean,
	age int,
	bedallotment text,
	city text,
	comment text,
	comorbidity boolean,
	contacthistory boolean,
	country text,
	dateOfthirdresult date,
	dateoffirstresult date,
	dateofsecondresult date,
	dischargedon date,
	district text,
	dob date,
	dod date,
	firstname text,
	firstresult text,
	landmark text,
	lastname text,
	mobilenumber text,
	outcome text,
	pincode int,
	secondresult text,
	sex text,
	state text,
	symptomstatus text,
	thirdresult text,
	travelhistory boolean,
	PRIMARY KEY (patientid, admittedon)
);
===============================================================================================================






----------------------------------------------------------------------------------------------------------------
sample insert:

INSERT INTO patientdetails (patientid,admittedon,covidactivestatus,age,city,country,dischargedon,district,dob,dod,firstname,landmark,lastname,mobilenumber,pincode,sex,state) VALUES ('b776ef4e-a269-11ea-bb37-df','2020-08-08',true,16,'nagpur','India',null,'nagpur','2001-01-01',null,'abc','school','xyz','98765914676',412455,'male','mh');
================================================================================================================

Sample patient:
POST : localhost:8080\covid\patient\
  {
    "firstName": "suny",
    "lastName": "xyz",
		"active": false,
    "age": 16,
    "sex": "female",
    "mobile": "346914676",
    "landmark": "school",
    "city": "nagpur",
    "state": "mh",
    "district": "nagpur",
    "country": "India",
    "pincode": 412455,
    "dateOfBirth": "2001-01-01",
    "dateOfDeath": "2001-01-01",
    "dateOfAdmission": "2020-02-02",
    "dateOfDischarge": "2020-02-03"
  }







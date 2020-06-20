Cassandra DB:
create keyspace covid_hms with replication={'class':'SimpleStrategy', 'replication_factor':1};

CREATE TABLE covid_hms.patientdetails (patientid text,admittedon date,actiontaken text,age int,bedallotment text,city text,comment text,comorbidity boolean,contacthistory boolean,country text,covidactivestatus boolean,dateoffirstresult date,dateoffirsttest date,dateofsecondresult date,dateofsecondtest date,dateofthirdresult date,dateofthirdtest date,dischargedon date,district text,dob date,dod date,firstname text,firstresult text,landmark text,lastname text,mobilenumber text,outcome text,pincode int,secondresult text,sex text,state text,symptomstatus text,thirdresult text,travelhistory boolean,PRIMARY KEY (patientid));
===============================================================================================================






----------------------------------------------------------------------------------------------------------------
sample insert:

INSERT INTO covid_hms.patientdetails (patientid,admittedon,covidactivestatus,age,city,country,dischargedon,district,dob,dod,firstname,landmark,lastname,mobilenumber,pincode,sex,state) VALUES ('b776ef4e-a269-11ea-bb37-df','2020-08-08',true,16,'nagpur','India',null,'nagpur','2001-01-01',null,'abc','school','xyz','98765914676',412455,'male','mh');
================================================================================================================

Sample patient:
POST : localhost:8080\covid\addPatient\

  {
   "patientid": "03544fd8-003c-43bb-af28-ead72a98639f",
    "firstname": "yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy",
    "lastname": "asdfsdgsdsdgasd",
    "age": 46,
    "sex": "male",
    "covidactivestatus": false,
    "mobilenumber": "98765914676",
    "landmark": "elephant",
    "city": "uganda",
    "state": "mh",
    "district": "undada",
    "country": "Africa",
    "pincode": 412455,
    "dob": "2001-01-01",
    "dod": "2020-07-08",
    "admittedon": "2020-07-08",
    "dischargedon": "2020-07-08",
    "travelhistory": null,
    "contacthistory": null,
    "comorbidity": null,
    "symptomstatus": null,
    "actiontaken": null,
    "bedallotment": null,
    "outcome": null,
    "dateoffirstresult": "2020-07-08",
    "firstresult": null,
    "dateofsecondresult": "2020-07-08",
    "secondresult": null,
    "dateofthirdresult": "2020-07-08",
    "thirdresult": null,
    "comment": null
  }







CREATE TABLE JOBS (
ID int8 not null, 
NAME varchar(200) not null, 
SALARY int8 not null,
CONSTRAINT jobs_pk PRIMARY KEY(ID));


CREATE TABLE GENDERS(
ID int8 not null, 
NAME VARCHAR(200) not null,
CONSTRAINT genders_pk PRIMARY KEY(ID));


CREATE TABLE EMPLOYEES (
ID int8 not null, 
GENDER_ID int8 not null, 
JOB_ID int8 not null,
NAME VARCHAR(200) not null, 
LAST_NAME VARCHAR(200) not null, 
BIRTHDATE DATE not null,
CONSTRAINT employees_pk PRIMARY KEY(ID),
CONSTRAINT employees_genders_fk FOREIGN KEY (GENDER_ID) REFERENCES GENDERS (ID),
CONSTRAINT employees_jobs_fk FOREIGN KEY (JOB_ID) REFERENCES JOBS (ID)
);
 

CREATE TABLE EMPLOYEE_WORKED_HOURS (
ID int8 not null, 
EMPLOYEE_ID int8 not null,
WORKED_HOURS int8 not null, 
WORKED_DATE DATE not null,
CONSTRAINT employee_worked_hours_pk PRIMARY KEY(ID),
CONSTRAINT employeeEorkedHours_employee_fk FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYEES (ID)
);


 create sequence SEC_EMPLOYEE_WORKED_HOURS
  start with 1
  increment by 1
  maxvalue 99999
  minvalue 1;

  create sequence SEC_EMPLOYEES
  start with 1
  increment by 1
  maxvalue 99999
  minvalue 1;
 
  create sequence SEC_GENDERS
  start with 1
  increment by 1
  maxvalue 99999
  minvalue 1;
 
  create sequence SEC_JOBS
  start with 1
  increment by 1
  maxvalue 99999
  minvalue 1;
CREATE TABLE GENDERS(
ID NUMBER(20) not null, 
NAME VARCHAR2(200) not null,
CONSTRAINT genders_pk PRIMARY KEY(ID));

CREATE TABLE JOBS (
ID NUMBER(20) not null, 
NAME VARCHAR2(200) not null, 
SALARY NUMBER(9) not null,
CONSTRAINT jobs_pk PRIMARY KEY(ID));

CREATE TABLE EMPLOYEE_WORKED_HOURS (
ID NUMBER(20) not null, 
EMPLOYEE_ID NUMBER(20) not null,
WORKED_HOURS NUMBER(3) not null, 
WORKED_DATE DATE not null,
CONSTRAINT employee_worked_hours_pk PRIMARY KEY(ID),
CONSTRAINT employeeEorkedHours_employee_fk FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYEES (ID)
);

CREATE TABLE EMPLOYEES (
ID NUMBER(20) not null, 
GENDER_ID NUMBER(ID) not null, 
JOB_ID NUMBER(20) not null,
NAME VARCHAR2(200) not null, 
LAST_NAME VARCHAR2(200) not null, 
BIRTHDATE DATE not null,
CONSTRAINT employees_pk PRIMARY KEY(ID)
CONSTRAINT employees_genders_fk FOREIGN KEY (GENDER_ID) REFERENCES GENDERS (ID),
CONSTRAINT employees_jobs_fk FOREIGN KEY (JOB_ID) REFERENCES JOBS (ID)
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

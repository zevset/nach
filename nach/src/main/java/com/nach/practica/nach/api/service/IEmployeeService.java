package com.nach.practica.nach.api.service;

import java.util.List;

import com.nach.practica.nach.entity.Employees;

public interface IEmployeeService {

	int createEmployee(int gender_Id, int job_id, String name,  String last_name, String birthdate);
	int assignHoursToEmployee( int employee_id, int worked_hours, String worked_date);
	List<Employees> listEmployees(int job_id);
	int getHoursByEmployee( int idEmployee, String dateIni,String dateEnd);
	int getSalaryByDate(int idEmployee, String dateIni,  String dateEnd);
}

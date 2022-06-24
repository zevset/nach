package com.nach.practica.nach.api.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nach.practica.nach.entity.EmployeesRepository;
import com.nach.practica.nach.entity.Genders;
import com.nach.practica.nach.entity.EmployeeWorkedHours;
import com.nach.practica.nach.entity.EmployeeWorkedHoursRepository;
import com.nach.practica.nach.entity.Employees;
import com.nach.practica.nach.entity.GendersRepository;
import com.nach.practica.nach.entity.Jobs;
import com.nach.practica.nach.entity.JobsRepository;
import com.nach.practica.nach.utils.Utilities;

@Service
public class EmployeeService implements IEmployeeService{
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);
	
	@Autowired
    protected EmployeesRepository employeesRepository;
	@Autowired
    protected EmployeeWorkedHoursRepository employeeWorkedHoursRepository;
	@Autowired
    protected GendersRepository gendersRepository;
	@Autowired
    protected JobsRepository jobsRepository;
		
	@Override
	public int createEmployee(int genderId, int jobId, String name, String lastName, String birthdate) {
		Utilities util = new Utilities();
		
		LOGGER.info( genderId +"-"+ jobId +"-"+ name +"-"+ lastName+"-"+ birthdate);
		
		Optional<Employees> responseEmployee = employeesRepository.findByCompleteName(name, lastName);
		Optional<Genders> responseGender = gendersRepository.findById(genderId);
		Optional<Jobs> responseJob = jobsRepository.findById(jobId);
		boolean isOld = util.isOld(birthdate);
		
		Employees employee = null;
		if(!responseEmployee.isPresent() && responseGender.isPresent() && responseJob.isPresent() && isOld) {
			Date birthdateD = util.getDate(birthdate);
			employee = new Employees(genderId, jobId, name, lastName, birthdateD);
			employee = employeesRepository.save(employee);
		}
		return employee.getId();
	}

	@Override
	public int assignHoursToEmployee(int employeeId, int worked_hours, String worked_date) {
		Utilities util = new Utilities();
		LOGGER.info( employeeId +"-"+ worked_hours +"-"+ worked_date );
		
		Optional<Employees> responseEmployee = employeesRepository.findById(employeeId);
		Date workedDate = util.getDate(worked_date);
		Optional<EmployeeWorkedHours> responseEmployeeWorkedHours = employeeWorkedHoursRepository.findByWorkedDateAndEmployeeId(workedDate, employeeId);
		boolean isDateValidate = util.isOtherDay(worked_date);
		boolean isHoursValidate = util.validateHours(worked_hours);
		
		EmployeeWorkedHours employeeWorkedHours = null;
		if(responseEmployee.isPresent() && isDateValidate && isHoursValidate && !responseEmployeeWorkedHours.isPresent()) {
			
			employeeWorkedHours = new EmployeeWorkedHours(employeeId, worked_hours, workedDate);
			LOGGER.info("jhoras: "+employeeWorkedHours.toString());
			employeeWorkedHours = employeeWorkedHoursRepository.save(employeeWorkedHours);
		}
		return employeeWorkedHours.getId();
		
	}

	@Override
	public List<Employees> listEmployees(int jobId) {
		LOGGER.info( ""+jobId );
		
		Optional<Jobs> responseJob = jobsRepository.findById(jobId);
		List<Employees> listEmployees= new ArrayList<>();
		if(responseJob.isPresent()) {
			listEmployees = employeesRepository.findByJobId(jobId);
		}
		return listEmployees;
		
	}

	@Override
	public int getHoursByEmployee(int employeeId, String dateIni, String dateEnd) {
		Utilities util = new Utilities();
		LOGGER.info( employeeId +"-"+ dateIni +"-"+ dateEnd );
		
		boolean dateValidate = util.isValidateDate(dateIni, dateEnd);
		LOGGER.info( ""+dateValidate);
		Optional<Employees> responseEmployee = employeesRepository.findById(employeeId);
		LOGGER.info( ""+responseEmployee.get().toString());
		int sum = 0;
		if(dateValidate && responseEmployee.isPresent()) {
			LOGGER.info( "logh4");
			Date dateDIni = util.getDate(dateIni);
			Date dateDEnd = util.getDate(dateEnd);
			List<EmployeeWorkedHours> list = employeeWorkedHoursRepository.findByWorkedDateInDays(dateDIni, dateDEnd, employeeId);
			sum = util.sumHours(list);
		}
		return sum;
		
	}

	@Override
	public int getSalaryByDate(int employeeId, String dateIni, String dateEnd) {
		Utilities util = new Utilities();
		LOGGER.info( employeeId +"-"+ dateIni +"-"+ dateEnd );
		
		Optional<Employees> responseEmployee = employeesRepository.findById(employeeId);
		Employees employe = responseEmployee.get();
		int idJob = employe.getJobId();
		int hours = this.getHoursByEmployee(employeeId, dateIni, dateEnd);
		
		Optional<Jobs> responseJob =  jobsRepository.findById(idJob);
		int salary = responseJob.get().getSalary();
		return util.sumPayments(hours, salary);
	}

}

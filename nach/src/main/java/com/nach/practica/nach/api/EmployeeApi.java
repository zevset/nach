package com.nach.practica.nach.api;

import java.util.List;
import java.util.Optional;

import javax.xml.ws.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nach.practica.nach.api.service.EmployeeService;
import com.nach.practica.nach.entity.Employees;


@RestController
@RequestMapping(value = "/natch/test")
public class EmployeeApi {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeApi.class);
	@Autowired
	private EmployeeService service;

    @RequestMapping(value="/CreateEmployee", method=RequestMethod.POST)
	public ResponseEntity createEmployee( @RequestBody RequestEmployee req) {		
    	
    	LOGGER.info(req.getGender_id()+" "+ req.getJob_id()+" "+ req.getName()+" "+  req.getLast_name()+" "+  req.getBirthdate().toString());
    	int res = service.createEmployee(req.getGender_id(), req.getJob_id(), req.getName(), req.getLast_name(), req.getBirthdate().toString());
    	if(res >0)
    		return new ResponseEntity<>(new ResponseCreate(res, true), HttpStatus.OK);

    	return new ResponseEntity<>(new ResponseCreate(null, false), HttpStatus.INTERNAL_SERVER_ERROR);
	}

    @RequestMapping(value="/AssingHours", method=RequestMethod.POST)
	public ResponseEntity assignHoursToEmployee( @RequestBody RequestHour req) {	
    	LOGGER.info(req.getEmployee_id()+" "+ req.getWorked_hours()+" "+ req.getWorked_date());
    	int res = service.assignHoursToEmployee(req.getEmployee_id(),req.getWorked_hours(), req.getWorked_date());
    	
    	if(res >0)
    		return new ResponseEntity<>(new ResponseCreate(res, true), HttpStatus.OK);

    	return new ResponseEntity<>(new ResponseCreate(null, false), HttpStatus.INTERNAL_SERVER_ERROR);
	}

    @RequestMapping(value="/ListEmployees", method=RequestMethod.GET)
    public  List<Employees>  listEmployees(@RequestBody RequestHour res) {
    	LOGGER.info("job_id {}", res.getId_job());
    	return service.listEmployees(res.getId_job());
		
	}

    @RequestMapping(value="/GetHours", method=RequestMethod.GET)
	public int getHoursByEmployee( @RequestBody RequestHour req) {
    	
    	LOGGER.info(req.getEmployee_id()+" "+ req.getStart_date()+" "+  req.getEnd_date());
    	return service.getHoursByEmployee(req.getEmployee_id(), req.getStart_date(), req.getEnd_date());
		
	}

	@RequestMapping(value="/GetSalary", method=RequestMethod.GET)
	public int  getSalaryByDate( @RequestBody RequestHour req) {
		LOGGER.info(req.getEmployee_id()+" "+ req.getStart_date()+" "+  req.getEnd_date());
		return service.getSalaryByDate(req.getEmployee_id(), req.getStart_date(), req.getEnd_date());
		
	}

	
	public void setService(EmployeeService service) {
		this.service = service;
	}
}

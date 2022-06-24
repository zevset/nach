package com.nach.practica.nach.api;

import java.io.Serializable;

public class RequestHour implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7961178617429562773L;
	private int job_id;
	private int employee_id;
	private int worked_hours ;
	private String worked_date;
	private String start_date;
	private String end_date;


	public int getWorked_hours() {
		return worked_hours;
	}

	public void setWorked_hours(int worked_hours) {
		this.worked_hours = worked_hours;
	}

	public String getWorked_date() {
		return worked_date;
	}

	public void setWorked_date(String worked_date) {
		this.worked_date = worked_date;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public int getJob_id() {
		return job_id;
	}

	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}
	
}

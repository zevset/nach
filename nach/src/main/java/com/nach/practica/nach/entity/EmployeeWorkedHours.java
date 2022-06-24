package com.nach.practica.nach.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "employee_worked_hours")
@SequenceGenerator(name = "idHour", sequenceName = "SEC_EMPLOYEE_WORKED_HOURS",allocationSize = 1)
public class EmployeeWorkedHours implements Serializable{

	private static final long serialVersionUID = -3086483372628328178L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idHour")
	private int id;
	
	@Column(name="employee_id")
	private int employeeId;
	
	@Column(name="worked_hours")
	private int workedHours;
	
	@Column(name="worked_date")
	private Date workedDate;
	
	
	public EmployeeWorkedHours() {
		
	}
	public EmployeeWorkedHours(int employeeId, int workedHours, Date workedDate) {
		super();
		this.employeeId = employeeId;
		this.workedHours = workedHours;
		this.workedDate = workedDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public int getWorkedHours() {
		return workedHours;
	}
	public void setWorkedHours(int workedHours) {
		this.workedHours = workedHours;
	}
	public Date getWorkedDate() {
		return workedDate;
	}
	public void setWorkedDate(Date workedDate) {
		this.workedDate = workedDate;
	}
	
	@Override
	public String toString() {
		return "EmployeeWorkedHours [id=" + id + ", employeeId=" + employeeId + ", workedHours=" + workedHours
				+ ", workedDate=" + workedDate + "]";
	}
	
	

}

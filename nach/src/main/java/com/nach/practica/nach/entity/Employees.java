package com.nach.practica.nach.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Employees")
@SequenceGenerator(name = "idEmployee", sequenceName = "sec_employees", allocationSize = 1)
public class Employees implements Serializable{

	private static final long serialVersionUID = -1860104664434964109L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idEmployee")
	private int id;
	
	@Column(name="gender_id")
	private int genderId;
	
	@Column(name="job_id")
	private int jobId;

	@Column(name="name")
	private String name;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="birthdate")
	@Temporal(TemporalType.DATE)
	private Date birthdate;
	
	public Employees() {
		
	}
	public Employees(int genderId, int jobId, String name, String lastName, Date birthdate) {
		super();
		this.genderId = genderId;
		this.jobId = jobId;
		this.name = name;
		this.lastName = lastName;
		this.birthdate = birthdate;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGenderId() {
		return genderId;
	}
	public void setGenderId(int genderId) {
		this.genderId = genderId;
	}
	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	
	@Override
	public String toString() {
		return "Employees [id=" + id + ", genderId=" + genderId + ", jobId=" + jobId + ", name=" + name + ", lastName="
				+ lastName + ", birthdate=" + birthdate + "]";
	}
	
}

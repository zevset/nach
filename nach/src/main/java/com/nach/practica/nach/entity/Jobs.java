package com.nach.practica.nach.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "idJob", sequenceName = "SEC_JOBS",allocationSize = 1)
public class Jobs implements Serializable{

	private static final long serialVersionUID = 1574475288476190248L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idJob")
	private int id;
	private String name;
	private int salary;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

	public int getSalary() {
		return salary;
	}
	@Override
	public String toString() {
		return "Jobs [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	

}

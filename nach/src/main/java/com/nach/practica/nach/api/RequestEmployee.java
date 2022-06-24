package com.nach.practica.nach.api;

import java.io.Serializable;
public class RequestEmployee implements Serializable{
	
	private static final long serialVersionUID = 2919223050566860834L;
	private int gender_id;
	private int job_id;
	private String name;
	private String last_name;
	private String birthdate;
	


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	@Override
	public String toString() {
		return "RequestEmployee [gender_Id=" + gender_id + ", job_Id=" + job_id + ", name=" + name + ", last_name="
				+ last_name + ", birthdate=" + birthdate + "]";
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public int getGender_id() {
		return gender_id;
	}
	public void setGender_id(int gender_id) {
		this.gender_id = gender_id;
	}
	public int getJob_id() {
		return job_id;
	}
	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}
	
	

}

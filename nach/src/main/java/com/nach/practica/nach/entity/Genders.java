package com.nach.practica.nach.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "idGender", sequenceName = "SEC_GENDERS",allocationSize = 1)
public class Genders implements Serializable{

	private static final long serialVersionUID = 3315123476776134807L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idGender")
	private int id;
	private String name;
	
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

	@Override
	public String toString() {
		return "Genders [id=" + id + ", name=" + name + "]";
	}
}

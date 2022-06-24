package com.nach.practica.nach.api;

import java.io.Serializable;

public class ResponseCreate implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7427492457465938170L;
	Integer id;
	boolean sucess;
	
	
	


	public ResponseCreate(Integer id, boolean sucess) {
		super();
		this.id = id;
		this.sucess = sucess;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isSucess() {
		return sucess;
	}
	
	public void setSucess(boolean sucess) {
		this.sucess = sucess;
	}
	@Override
	public String toString() {
		return "ResponseCreate [id=" + id + ", sucess=" + sucess + "]";
	}
	
	

}

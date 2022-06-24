package com.nach.practica.nach.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nach.practica.nach.entity.EmployeeWorkedHours;

public class Utilities {
	private static final Logger LOGGER = LoggerFactory.getLogger(Utilities.class);
	
	public boolean isOld(String birthDate) {

		LocalDate birthDateLD = LocalDate.parse(birthDate);
		long yearsOld = ChronoUnit.YEARS.between(birthDateLD, LocalDateTime.now());
		if(yearsOld>= 18)
			return true;
		
		return false;
	}
	
	public boolean isOtherDay(String date) {

		LocalDate dateD = LocalDate.parse(date);
		long yearsOld = ChronoUnit.DAYS.between(dateD, LocalDateTime.now());
		if(yearsOld>= 0)
			return true;
		
		return false;
	}
	
	public boolean isValidateDate(String dateIni, String dateEnd) {

		LocalDate dateDIni = LocalDate.parse(dateIni);
		LocalDate dateDEnd = LocalDate.parse(dateEnd);
		long days = ChronoUnit.DAYS.between(dateDIni, dateDEnd);
		if(days>= 0)
			return true;
		
		return false;
	}
	
	public boolean validateHours(int hours) {
		if(hours<= 20)
			return true;
		
		return false;
	}
	
	public Date getDate(String date){
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return formato.parse(date);
		} catch (ParseException e) {
			LOGGER.error("Error transformando fecha");
		}
		return null;
	}
	
	
	public Date getDateToday() throws ParseException {
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	     String dateToday = dtf.format(LocalDateTime.now());
	     
	     SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	     return formato.parse(dateToday);
	}
	
	public int sumHours(List<EmployeeWorkedHours> list) {
		int sum = 0;
		for(EmployeeWorkedHours hour:list ) {
			sum +=hour.getWorkedHours();
		}
		return sum;
	}
	
	public int sumPayments(int hours, int salary) {
		return hours *salary;
	}


}

package com.nach.practica.nach.entity;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeWorkedHoursRepository extends JpaRepository<EmployeeWorkedHours, Integer>{

	@Query("select c from EmployeeWorkedHours c where c.workedDate = :worked_date and employeeId =:employee_id")
	Optional<EmployeeWorkedHours> findByWorkedDateAndEmployeeId(@Param("worked_date") Date workedDate, @Param("employee_id") int employeeId );
	
	@Query("select c from EmployeeWorkedHours c where :dateIni <= workedDate and :dateEnd>= workedDate and employeeId =:employee_id")
	List<EmployeeWorkedHours> findByWorkedDateInDays(@Param("dateIni") Date dateIni, @Param("dateEnd") Date dateEnd,
			@Param("employee_id") int employeeId );
	Optional<EmployeeWorkedHours> findByWorkedDate(@Param("worked_date") Date workedDate );
}

package com.nach.practica.nach.entity;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeesRepository extends JpaRepository<Employees, Integer>{
	
	@Query("select c from Employees c where c.name = :name and last_name =:last_name")
	Optional<Employees> findByCompleteName(@Param("name") String name, @Param("last_name") String lastname);
	
	List<Employees> findByJobId(@Param("job_id") int jobId);
}

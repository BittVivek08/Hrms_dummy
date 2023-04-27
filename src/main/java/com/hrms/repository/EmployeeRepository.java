package com.hrms.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hrms.entity.EmployeeDetails;

public interface EmployeeRepository extends JpaRepository<EmployeeDetails, Integer>{

	
	
	//@Query("SELECT empId,firstName,dateOfBirth,lastName FROM EmployeeDetails where ")
	//List<Object[]> findEmployeeDetails();
	

}

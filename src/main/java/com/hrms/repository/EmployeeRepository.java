package com.hrms.repository;

<<<<<<< HEAD

import java.util.List;
=======
import java.util.Optional;

>>>>>>> 583b3706a9b47173e4d2ee1a313ad803c58da7a4
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hrms.entity.EmployeeDetails;

public interface EmployeeRepository extends JpaRepository<EmployeeDetails, Integer>{
<<<<<<< HEAD

	
	
	//@Query("SELECT empId,firstName,dateOfBirth,lastName FROM EmployeeDetails where ")
	//List<Object[]> findEmployeeDetails();
	

=======
	
	Optional<EmployeeDetails> findByEmailAndPassword(String email, String password);
	
	EmployeeDetails findByEmail(String email);
	
	EmployeeDetails findByFirstName(String firstName);
>>>>>>> 583b3706a9b47173e4d2ee1a313ad803c58da7a4
}

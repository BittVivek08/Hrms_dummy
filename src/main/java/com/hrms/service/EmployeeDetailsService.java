package com.hrms.service;

import java.util.List;

<<<<<<< HEAD
import com.hrms.beans.EmpBirthResponse;
import com.hrms.beans.EntityBeanResponse;

=======

import com.hrms.beans.EntityBeanResponse;
import com.hrms.beans.LoginDto;
>>>>>>> 583b3706a9b47173e4d2ee1a313ad803c58da7a4
import com.hrms.entity.EmployeeDetails;




public interface EmployeeDetailsService {
	
	public EntityBeanResponse saveEmpDetails(EmployeeDetails empDetails);
	
	public List<EmployeeDetails> getAllEmpDetails();
	
	public EmployeeDetails getEmpById(Integer id);
	
	public EntityBeanResponse updateEmpDetails(EmployeeDetails employeeDetails);
	
<<<<<<< HEAD
	public List<EmpBirthResponse> findBirthdayDetails();


	
=======
	public EntityBeanResponse loginEmployee(LoginDto loginDto);
	

>>>>>>> 583b3706a9b47173e4d2ee1a313ad803c58da7a4

}

package com.hrms.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "main_employees")
public class EmployeeDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String empId;
	
	private String firstName;
	
	private String lastName;
	
	@Column(name = "dob")
	private String dateOfBirth;
	
	private String empRole;
	
	private String qualification;
	
	private Long mobileNumber;
	
	private String email;
	
	private String password;
	
	private String gender;
	
<<<<<<< HEAD
	
	
	
=======
	private String image;
>>>>>>> 583b3706a9b47173e4d2ee1a313ad803c58da7a4
}

	
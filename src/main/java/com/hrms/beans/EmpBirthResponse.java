package com.hrms.beans;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class EmpBirthResponse {
	private int empid;
	private String firstname;
	private String lastname;
	private String dob;
}

	
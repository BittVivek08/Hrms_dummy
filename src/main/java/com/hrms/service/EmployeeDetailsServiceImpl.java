package com.hrms.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.hrms.beans.EmployeeDto;
import com.hrms.beans.EntityBeanResponse;
import com.hrms.beans.LoginDto;
import com.hrms.entity.EmployeeDetails;
import com.hrms.repository.EmployeeRepository;

@Service
public class EmployeeDetailsServiceImpl implements EmployeeDetailsService {

	@Autowired
	private EmployeeRepository empRepo;

	@Autowired
	private EntityBeanResponse ebr;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public EntityBeanResponse saveEmpDetails(EmployeeDetails employeeDetails)  {
		String encode = this.passwordEncoder.encode(employeeDetails.getPassword());
		employeeDetails.setPassword(encode);
		
		
		  EmployeeDetails saved = empRepo.save(employeeDetails);
		if (saved != null) {
			ebr.setMsg("Employee Details Saved Successfully");
			ebr.setStatus(true);
		} else {
			ebr.setMsg("Employee Details Saving Failed");
			ebr.setStatus(false);
		}
		return ebr;
	}

	@Override
	public List<EmployeeDetails> getAllEmpDetails() {

		return empRepo.findAll();
	}

	@Override
	public EmployeeDetails getEmpById(Integer id) {
		Optional<EmployeeDetails> findById = empRepo.findById(id);

		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public EntityBeanResponse updateEmpDetails(EmployeeDetails employeeDetails) {
		EmployeeDetails update = empRepo.save(employeeDetails);
		if (update != null) {
			ebr.setMsg("Employee Details Updated Successfully");
			ebr.setStatus(true);
		} else {
			ebr.setMsg("Employee Details Updation Failed");
			ebr.setStatus(false);
		}
		return ebr;
	}

	@Override
	public EntityBeanResponse loginEmployee(LoginDto loginDto) {

		EmployeeDetails employee1 = empRepo.findByEmail(loginDto.getEmail());

		if (employee1 != null) {
			String password = loginDto.getPassword();
			String encodedPassword = employee1.getPassword();
			boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
			if (isPwdRight) {
				Optional<EmployeeDetails> employee = empRepo.findByEmailAndPassword(loginDto.getEmail(),
						encodedPassword);
				EmployeeDto empDto = new EmployeeDto();
				empDto.setId(employee1.getId());
				empDto.setEmpId(employee1.getEmpId());
				empDto.setFirstName(employee1.getFirstName());
				empDto.setLastName(employee1.getLastName());
				empDto.setEmpRole(employee1.getEmpRole());
				empDto.setEmail(employee1.getEmail());
				empDto.setGender(employee1.getGender());
				empDto.setDateOfBirth(employee1.getDateOfBirth());
				empDto.setQualification(employee1.getQualification());
				empDto.setMobileNumber(employee1.getMobileNumber());
				ebr.setEmployeeDto(empDto);
				if (employee.isPresent()) {
					ebr.setStatus(true);
					ebr.setMsg("Login Success");
				} else {
					ebr.setStatus(false);
					ebr.setMsg("Login Failed");
					ebr.setEmployeeDto(null);
				}

			} else {
				ebr.setStatus(false);
				ebr.setMsg("password not matched");
				ebr.setEmployeeDto(null);
			}
		} else {
			ebr.setStatus(false);
			ebr.setMsg("Email Does Not Exits");
			ebr.setEmployeeDto(null);
		}
		return ebr;
	}
}

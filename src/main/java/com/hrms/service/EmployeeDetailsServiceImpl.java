package com.hrms.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.beans.EmpBirthResponse;
import com.hrms.beans.EntityBeanResponse;
import com.hrms.entity.EmployeeDetails;
import com.hrms.repository.EmployeeRepository;

@Service
public class EmployeeDetailsServiceImpl implements EmployeeDetailsService{

	@Autowired
	private EmployeeRepository empRepo;

	@Autowired
	private EntityBeanResponse ebr;

	@Override
	public EntityBeanResponse saveEmpDetails(EmployeeDetails employeeDetails) {
		EmployeeDetails saved = empRepo.save(employeeDetails);
		if(saved !=null ) {
			ebr.setMsg("Employee Details Saved Successfully");
			ebr.setStatus(true);
		}else {
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

		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public EntityBeanResponse updateEmpDetails(EmployeeDetails employeeDetails) {
		EmployeeDetails update = empRepo.save(employeeDetails);
		if(update != null) {
			ebr.setMsg("Employee Details Updated Successfully");
			ebr.setStatus(true);
		}else {
			ebr.setMsg("Employee Details Updation Failed");
			ebr.setStatus(false);
		}
		return ebr;
	}
	@Override
	public List<EmpBirthResponse> findBirthdayDetails() {
		List<EmployeeDetails> empList =  empRepo.findAll();
		List<EmployeeDetails> empListBirhdays = new ArrayList<>();
		List<EmpBirthResponse> lis = new ArrayList<>();
		LocalDate today = LocalDate.now();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try {
			for (EmployeeDetails emp : empList) {

				Date dob = sdf.parse(emp.getDateOfBirth());

				if (dob.getDate() == today.getDayOfMonth()
						&& dob.getMonth()+1 == today.getMonthValue()) {
					
					EmpBirthResponse res = new EmpBirthResponse();
					res.setFirstname(emp.getFirstName());
					res.setLastname(emp.getLastName());
					res.setDob(emp.getDateOfBirth());
					res.setEmpid(emp.getEmpId());
					lis.add(res);
					empListBirhdays.add(emp);
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}

		return lis;
	}

	








}



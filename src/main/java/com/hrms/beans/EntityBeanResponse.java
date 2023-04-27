package com.hrms.beans;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class EntityBeanResponse {
	
	private String msg;
	
	private boolean status;
	
	private EmployeeDto employeeDto;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "EntityBeanResponse [msg=" + msg + ", status=" + status + "]";
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	

}

package com.example.exception;

import org.springframework.http.HttpStatus;

public class EmployeeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	String mess;

	public EmployeeNotFoundException(String mess, HttpStatus http) {
		super();
		this.mess = mess;
	}
	

}

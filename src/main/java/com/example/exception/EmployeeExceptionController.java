package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class EmployeeExceptionController extends RuntimeException{
	
	
	private static final long serialVersionUID = 1L;

	@ExceptionHandler(value=EmployeeNotFoundException.class)
	public ResponseEntity<Object> employeeNotFoundExceptionHandller(EmployeeNotFoundException exception) {
		return new ResponseEntity<>("Employee Not Found ",HttpStatus.NOT_FOUND);
		
	}

}

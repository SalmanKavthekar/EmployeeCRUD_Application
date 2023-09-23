package com.example.service;

import java.util.List;


import com.example.model.Employee;

public interface EmployeeService {
	
	public Employee saveEmployee(Employee employee);
	
	public Employee getEmployeeById(Integer id);

	public List<Employee> getAllEmployee();
	
	public Employee updateEmployeeById(Integer id, Employee updateEmployeeById);

	public void deleteEmployeeById(Integer id);
	
	
//	public List<Employee> getEmployeeByCity(String city);
//	
//	public List<Employee> getEmployeeByName(String name);
//	
//	public List<Employee> getEmployeeByNameAndCity(String name,String city);
//	
//	

}

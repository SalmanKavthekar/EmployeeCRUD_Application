package com.example.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.controller.EmployeeController;
import com.example.exception.EmployeeNotFoundException;
import com.example.model.Employee;
import com.example.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	// for logger
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(Integer id) {

		Optional<Employee> optionalEmployee = employeeRepository.findById(id);

		if (optionalEmployee.isPresent()) {
			return optionalEmployee.get();
		} else {
			throw new EmployeeNotFoundException(" Employee Not Found ", HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee updateEmployeeById(Integer id, Employee updateEmployeeById) {
		Optional<Employee> optionalEmp = employeeRepository.findById(id);
		if (optionalEmp.isPresent()) {
			Employee emp = optionalEmp.get();
			emp.setName(updateEmployeeById.getName());
			emp.setCity(updateEmployeeById.getCity());
			emp.setPosition(updateEmployeeById.getPosition());
			return employeeRepository.save(emp);
		} else {
			throw new EmployeeNotFoundException("Employee Not Found ", HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public void deleteEmployeeById(Integer id) {
		employeeRepository.deleteById(id);

	}

//
//	@Override
//	public List<Employee> getEmployeeByCity(String city) {
//		List<Employee> employee=employeeRepository.findByCity(city);
//		return employee;
//	}
//	
//	@Override
//	public List<Employee> getEmployeeByName(String name){
//		List<Employee> empName=employeeRepository.findByName(name);
//		return empName;
//	}
//
//	@Override
//	public List<Employee> getEmployeeByNameAndCity(String name, String city) {
//		List<Employee> empList=employeeRepository.findByNameAndCity(name, city);
//		return empList;
//	}
//
//	

}

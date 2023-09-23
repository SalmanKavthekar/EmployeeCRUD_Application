package com.example.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.example.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	// for logger
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/save")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		Employee emp = employeeService.saveEmployee(employee);
		return ResponseEntity.ok().body(emp);
	}

	@GetMapping("/getEmployee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id) {
		Employee empId = employeeService.getEmployeeById(id);
		return ResponseEntity.ok().body(empId);
	}

	@GetMapping("/allEmployee")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> Allemp = employeeService.getAllEmployee();
		return ResponseEntity.ok().body(Allemp);
	}

	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {
		Employee empUpdate = employeeService.updateEmployeeById(id, employee);
		return ResponseEntity.ok().body(empUpdate);
	}

	@DeleteMapping("/deleteEmployee/{id}")
	public String deleteEmployeeById(@PathVariable Integer id) {
		employeeService.deleteEmployeeById(id);
		return "Deleted Successfully";
	}

//	// design native method for fetch data by using city name
//	@GetMapping("/getEmpByCity/{city}")
//	public ResponseEntity<List<Employee>> getEmployeeByCity(@PathVariable("city") String city) {
//		List<Employee> empList = employeeService.getEmployeeByCity(city);
//
//		return ResponseEntity.ok().body(empList);
//
//	}
//
//	// design native method to fetch data by using name
//	@GetMapping("/getEmpByName/{name}")
//	public ResponseEntity<List<Employee>> getEmployeeByName(@PathVariable("name") String name) {
//		// LOGGER.warn("this is warn");
//		List<Employee> empName = employeeService.getEmployeeByName(name);
//		return ResponseEntity.ok().body(empName);
//	}
//
//	// @RequestParam("id") String orderId, Model model){
//	// model.addAttribute("orderId", orderId);
//	// Design native method to fetch data by using name and city
//	@GetMapping("/getEmpNameCity")
//	public ResponseEntity<List<Employee>> getEmpByNameAndCity(@RequestParam String name, @RequestParam String city) {
//		// List<Employee> empList=employeeService.getEmployeeByNameAndCity(name, city);
//		// return ResponseEntity.ok().body(empList);
//		return new ResponseEntity<List<Employee>>(employeeService.getEmployeeByNameAndCity(name, city), HttpStatus.OK);
//
//	}

}

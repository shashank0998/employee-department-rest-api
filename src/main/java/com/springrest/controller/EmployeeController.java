package com.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.entity.Department;
import com.springrest.entity.Employee;
import com.springrest.service.EmployeeService;

@RestController
public class EmployeeController 
{
	@Autowired
	EmployeeService empService;
	
	@PostMapping("/employees")
	public String saveEmployee(Employee emp)
	{
		if(empService.saveEmployee(emp))
			return "Employee save successfully";
		else
			return "oops you are not save...! please again";
	}
	
	@GetMapping("/employees")
	public List<Employee> getEmployee()
	{
		return empService.getEmployee();
	}
	
	@GetMapping("/employee/{id}")
	public Employee getEmployee(int id)
	{
		return empService.getEmployee(id);
	}
	
	@GetMapping("/employees/{id}/departments")
	public List<Department> getEmployeeDepartmentByID(int id)
	{
		return empService.getEmployeeDepartmentByID(id);
	}
	
	@GetMapping("/employees/{id}/departments/{id}")
	public Department getEmployeeDepartment(int id)
	{
		return empService.getEmployeeDepartment(id);
	}
	
	@GetMapping("/departments")
	public List<Department> getDepartment()
	{
		return empService.getDepartment();
	}
}

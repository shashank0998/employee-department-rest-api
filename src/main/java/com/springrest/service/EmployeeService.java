package com.springrest.service;

import java.util.List;

import com.springrest.entity.Department;
import com.springrest.entity.Employee;

public interface EmployeeService {

	public boolean saveEmployee(Employee emp);

	public List<Employee> getEmployee();

	public Employee getEmployee(int id);

	public List<Department> getEmployeeDepartmentByID(int id);

	public Department getEmployeeDepartment(int id);

	public List<Department> getDepartment();

}

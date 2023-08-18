package com.springrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.dao.EmployeeDepartmentDao;
import com.springrest.entity.Department;
import com.springrest.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService
{

	@Autowired
	EmployeeDepartmentDao empDeptDao;

	@Override
	public boolean saveEmployee(Employee emp) 
	{		
		return empDeptDao.saveEmployee(emp);
	}

	@Override
	public List<Employee> getEmployee() 
	{
		return empDeptDao.getEmployee();
	}

	@Override
	public Employee getEmployee(int id)
	{
		return empDeptDao.getEmployee(id);
	}

	@Override
	public List<Department> getEmployeeDepartmentByID(int id) 
	{
		return empDeptDao.getEmployeeDepartmentByID(id);
	}

	@Override
	public Department getEmployeeDepartment(int id) 
	{
		return empDeptDao.getEmployeeDepartment(id);
	}

	@Override
	public List<Department> getDepartment() 
	{
		return empDeptDao.getDepartment();
	}
	
	
}

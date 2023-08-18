package com.springrest.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Employee 
{
	@Id
	int id;
	
	@Column
	int departmentId;
	
	@Column
	String name;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,orphanRemoval=true)
	@JoinColumn
	@Autowired
	List<Department> department;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Employee(int id, int departmentId, String name, List<Department> department) {
		super();
		this.id = id;
		this.departmentId = departmentId;
		this.name = name;
		this.department = department;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", departmentId=" + departmentId + ", name=" + name + ", department=" + department
				+ "]";
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Department> getDepartment() {
		return department;
	}

	public void setDepartment(List<Department> department) {
		this.department = department;
	}

	
}

package com.springrest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Department 
{
	@Id
	int id;
	
	@Column
	String departmentName;
	
	@Column
	String teamLeadName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getTeamLeadName() {
		return teamLeadName;
	}

	public void setTeamLeadName(String teamLeadName) {
		this.teamLeadName = teamLeadName;
	}

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(int id, String departmentName, String teamLeadName) {
		super();
		this.id = id;
		this.departmentName = departmentName;
		this.teamLeadName = teamLeadName;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", departmentName=" + departmentName + ", teamLeadName=" + teamLeadName + "]";
	}
	
	
}

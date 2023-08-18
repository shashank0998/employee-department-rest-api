package com.springrest.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springrest.entity.Department;
import com.springrest.entity.Employee;

@Repository
public class EmployeeDepartmentDaoImpl implements EmployeeDepartmentDao
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean saveEmployee(Employee emp) 
	{
		boolean result = false;
		
		try 
		{
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			
			session.save(emp);
			
			tx.commit();
			session.close();
			result = true;
			
		}
		catch (Exception e) 
		{
			System.out.println("Error while saving.....:-"+e.getMessage());
		}
		
		return result;
	}

	@Override
	public List<Employee> getEmployee() 
	{
		List<Employee> listEmp = null;
		
		try 
		{
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			
			Query<Employee> query = session.createQuery("from Employee");
			listEmp = query.getResultList();
			
			tx.commit();
			session.close();
			
		} 
		catch (HibernateException e) 
		{
			System.out.println("Error while getting.....:-"+e.getMessage());
		}
		
		return listEmp;
	}

	@Override
	public Employee getEmployee(int id) 
	{
		Employee emp = null;
		
		try 
		{
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			
			emp = session.get(Employee.class, id);
			tx.commit();
			session.close();
			
		} 
		catch (HibernateException e) 
		{
			System.out.println("Error while getting......:-"+e.getMessage());
		}
		
		return emp;
	}

	@Override
	public List<Department> getEmployeeDepartmentByID(int id) 
	{
		Employee emp = null;
		List<Department> deptList = null;
		
		try 
		{
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			
			emp = session.get(Employee.class, id);
			
			tx.commit();
			session.close();
			
		} 
		catch (HibernateException e) 
		{
			System.out.println("Error while getting.......:-"+e.getMessage());
		}
		return emp.getDepartment();
	}

	@Override
	public Department getEmployeeDepartment(int id) 
	{
		Department dept = null;
		
		try 
		{
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			
			dept = session.get(Department.class, id);
			
			tx.commit();
			session.close();
		} 
		catch (HibernateException e) 
		{
			System.out.println("Error while getting.......:-"+e.getMessage());
		}
		
		return dept;
	}

	@Override
	public List<Department> getDepartment() 
	{
		List<Department> listDept = null;
		
		try 
		{
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			
			Query<Department> query = session.createQuery("from Department");
			listDept = query.getResultList();
			
			tx.commit();
			session.close();
		}
		catch (HibernateException e) 
		{
			System.out.println("Error while getting........:-"+e.getMessage());
		}
		return listDept;
	}

}

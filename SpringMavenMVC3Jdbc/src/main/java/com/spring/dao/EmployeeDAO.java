package com.spring.dao;

import java.util.List;

import com.spring.bean.Employee;


//CRUD operations
public interface EmployeeDAO {
	
	//Create
	public void save(Employee employee);
	
	public List<Employee> getAll();
	
}

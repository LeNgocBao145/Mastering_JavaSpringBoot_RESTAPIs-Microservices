package com.example.restdemo.dao;

import java.util.List;

import com.example.restdemo.entity.Employee;

public interface EmployeeDao {
 
	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public Employee save(Employee employee); // insert and update
	
	public void deleteById(int id);	

}

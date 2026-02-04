package com.example.mvccrud.service;

import java.util.List;
import java.util.Optional;

import com.example.mvccrud.entity.Employee;

public interface EmployeeService {

	List<Employee> findAll();
	
	Optional<Employee> findById(int id);
	
	Employee save(Employee emp);
	
	void deleteByID(int id);
	
	
}

package com.example.mvccrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mvccrud.entity.Employee;
import com.example.mvccrud.repo.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> findAll() {		
		return employeeRepository.findAll();
	}

	@Override
	public Optional<Employee> findById(int id) {
		
		return employeeRepository.findById(id);
	}

	@Override
	public Employee save(Employee emp) {
		
		return employeeRepository.save(emp);
	}

	@Override
	public void deleteByID(int id) {
		
		employeeRepository.deleteById(id);
	}

	
}

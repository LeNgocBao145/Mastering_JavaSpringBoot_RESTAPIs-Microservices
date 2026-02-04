package com.example.mvccrud.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mvccrud.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
// CRUD methods
}

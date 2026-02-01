package com.example.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa.dao.StudentDao;
import com.example.jpa.entity.Student;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	@Autowired
	private StudentDao studentDao;
	
	@PostMapping
	public String addStudent(@RequestBody Student stu) {
		studentDao.save(stu);
		return "Create student successfully";
	}
	
	@GetMapping("/{studentId}")
	public Student getStudent(@PathVariable Integer studentId) {
		return studentDao.findById(studentId);
	}
	
	@GetMapping
	public List<Student> getAllStudents() {
		return studentDao.findAll();
	}
	
	@PutMapping
	public String updateStudent(@RequestBody Student stu) {
		return studentDao.update(stu);
	}
	
	@DeleteMapping("/{studentId}")
	public String deleteStudent(@PathVariable Integer studentId) {
		studentDao.deleteById(studentId);
		return "Student with id " + studentId + " deleted successfully!";
	}
}

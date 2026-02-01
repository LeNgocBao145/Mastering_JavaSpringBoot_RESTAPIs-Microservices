package com.example.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa.dao.StudentDao;
import com.example.jpa.entity.Student;

@RestController
public class StudentController {
    
	@Autowired
	private StudentDao studentDao;
	
	// CRUD - create
	@PostMapping("/students")
	public String addStudent(@RequestBody Student stud) {
		studentDao.save(stud);
		return "Student saved successfully";
	}
	
	// CRUD - reading a single object
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable Integer studentId) {
		return studentDao.findById(studentId); // Jackson
	}
	
	// CRUD - reading all objects
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		return studentDao.findAll(); // JSON array - Jackson
	}
	
	// CRUD - update
		@PutMapping("/students")
		public String updateStudent(@RequestBody Student stud) {
			studentDao.update(stud);
			return "Student updated successfully";
		}
		
	// CRUD - delete
	@DeleteMapping("/students/{studentId}")
	public String deleteStudent(@PathVariable Integer studentId) {
		studentDao.deletebyId(studentId);
		return "Student with id: "+studentId+" deleted successfully";
	}
		
	
}

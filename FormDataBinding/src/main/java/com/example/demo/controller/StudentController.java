package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Student;
//import com.example.demo.service.StudentService;

@Controller
public class StudentController {
//	@Autowired
//	StudentService studentService;
	@Value("${countries}")
	private List<String> countries;
	
	@GetMapping("/showStudentForm")
	public String showForm(Model model) {
		model.addAttribute("student", new Student());
		model.addAttribute("countries", countries);
		return "student-form";
	}
	
	@PostMapping("/processStudentForm")
	public String processForm(@ModelAttribute("student") Student student) {
		System.out.println("Student: " + student.getFirstName() + " " + student.getLastName());
		System.out.println("Country: " + student.getCountry());
		return "student-confirmation";
	}
}

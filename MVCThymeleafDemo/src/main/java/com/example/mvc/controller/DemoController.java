package com.example.mvc.controller;

import com.example.mvc.MvcThymeleafDemoApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DemoController {
	@GetMapping
	public String getDate(Model model) {
		model.addAttribute("date1", new java.util.Date());	
		return "date"; 
	}
	
	@GetMapping("/showForm")
	public String showForm() {
		return "hello-form";
	}
	
	@PostMapping("/processForm")
	public String processForm(@RequestParam("name") String name, Model model) {
		model.addAttribute("name", name.toUpperCase());
		return "result";
	}
}

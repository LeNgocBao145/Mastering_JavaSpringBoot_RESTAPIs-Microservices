package com.example.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	@GetMapping
	public String getDate(Model model) {
		model.addAttribute("date1", new java.util.Date());	
		return "date"; 
	}
}

package com.example.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MyController {
	@GetMapping("/hello")
	public String sayHello() {
		return "<h1 style='color:red'>Hello World<h1/>";
	}

	@GetMapping("/hi")
	public String sayHi() {
		return "<h1 style='color:blue'>Hi Spring Boot<h1/>";
	}
	
	@GetMapping("/bye")
	public String sayBye() {
		return "<h1 style='color:orange'>Bye Bye SpringBoot...<h1/>";
	}
}

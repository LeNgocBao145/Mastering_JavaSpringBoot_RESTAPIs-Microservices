package com.example.mvccrud.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mvccrud.entity.Employee;
import com.example.mvccrud.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/list")
	public String listEmployees(Model model) {
		List<Employee> emps = employeeService.findAll();
		model.addAttribute("employees",emps);
		return "list-emps"; // thymeleaf page
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
	// create model attribute to bind form data 
	Employee employee = new Employee();
	theModel.addAttribute("employee", employee); 
	return "employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee)
	{
	// save the employee 
	employeeService.save(employee);
	// use a redirect to prevent duplicate submissions 
	return "redirect:/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId,
	Model theModel) {
	// get the employee from the service
	Optional <Employee> theEmployee = employeeService.findById(theId);
	// set employee as a model attribute to pre-populate the form 
	theModel.addAttribute("employee", theEmployee);
	// send over to our form
	return "employee-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId)
	{
	// delete the employee 
	employeeService.deleteByID(theId);
	// redirect to /employees/list 
	return "redirect:/list";
	}
}

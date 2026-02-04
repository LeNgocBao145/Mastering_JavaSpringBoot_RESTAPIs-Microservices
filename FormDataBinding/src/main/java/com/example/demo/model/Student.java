package com.example.demo.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	private String firstName;
	private String lastName;
	
	private String country;
	private String favLanguage;
	private List<String> favOS;
}

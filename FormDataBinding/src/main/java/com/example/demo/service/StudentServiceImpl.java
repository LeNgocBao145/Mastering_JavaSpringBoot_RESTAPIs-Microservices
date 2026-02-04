//package com.example.demo.service;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.example.demo.model.Student;
//import com.example.demo.repository.StudentRepository;
//
//@Service
//@Transactional
//public class StudentServiceImpl implements StudentService {
//	@Autowired
//	StudentRepository studentRepository;
//	
//	@Override
//	public List<Student> findAll() {
//		return studentRepository.findAll();		
//	}
//
//	@Override
//	public Optional<Student> findById(int id) { 
//		return studentRepository.findById(id);
//	}
//
//	@Override
//	public void deleteById(int id) {		
//		studentRepository.deleteById(id);
//	}
//
//	@Override
//	public Student save(Student stu) { 
//		return studentRepository.save(stu);
//	}
//	
//}

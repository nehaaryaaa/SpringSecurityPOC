package com.neosoft.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.model.Project;
import com.neosoft.model.Student;
import com.neosoft.repository.StudentRepository;

@RestController
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepo;
	
	@PostMapping("/insert/student")
	public Student insertStudent(@RequestBody Student student) {
		return studentRepo.save(student);
	}
	
	@GetMapping("/all/student")
	public List<Student> getAllStudents(){
		return studentRepo.findAll();
	}
	
	@GetMapping("/findByStudentId/{id}")
	public List<Project> getProjectByStudentId(@PathVariable Long id){
		Optional<Student> s= studentRepo.findById(id);
		return s.get().getProject();
	}
}

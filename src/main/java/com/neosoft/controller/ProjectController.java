package com.neosoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.model.Project;
import com.neosoft.repository.ProjectRepository;

@RestController
public class ProjectController {

	@Autowired
	private ProjectRepository projectRepo;
	
	@PostMapping("/insert/project")
	public Project insertProject(@RequestBody Project project) {
		return projectRepo.save(project);
	}
	
	@GetMapping("/all/project")
	public List<Project> getAllProjects(){
		return projectRepo.findAll();
	}
}

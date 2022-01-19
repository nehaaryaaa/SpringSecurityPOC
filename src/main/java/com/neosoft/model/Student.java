package com.neosoft.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(max = 65)
	private String fname;
	
	@NotNull
	@Size(max = 65)
	private String lname;
	
	@NotNull
	@Size(max = 10)
	private String mobile;
	
	@NotNull
	@Size(max = 120)
	@Column(unique = true)
	private String email;
	
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference
    private List<Project> project;
	
	
	
}

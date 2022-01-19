package com.neosoft.model;

import javax.persistence.*; 
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

@Data
@Entity
@Table(name = "project")
public class Project {

	@Id
	@Column(name = "proj_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long projid;
	
	@NotNull
	@Size(max = 65)
	@Column(name = "proj_name")
	private String projname;
	
	@NotNull
	@Size(max = 65)
	@Column(name = "proj_duration")
	private String projduration;
	
	@ManyToOne
    @JoinColumn(name = "id", nullable = false)
	@JsonBackReference
    private Student student;
}

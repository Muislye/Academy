package com.accenture.Academic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="courses")
public class Courses {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_courses")
	private int idCourses;
	
	private String name;
	private String description;
	private String language;
	@Column(name= "estimated_date")
	private String estimatedDate;
	
	
	public Courses() {
		
	}


	public int getIdCourses() {
		return idCourses;
	}


	public void setIdCourses(int idCourses) {
		this.idCourses = idCourses;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getLanguage() {
		return language;
	}


	public void setLanguage(String language) {
		this.language = language;
	}


	public String getEstimatedDate() {
		return estimatedDate;
	}


	public void setEstimatedDate(String estimatedDate) {
		this.estimatedDate = estimatedDate;
	}
	
	
	
}

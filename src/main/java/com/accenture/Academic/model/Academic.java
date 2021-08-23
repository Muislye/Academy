package com.accenture.Academic.model;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="academic")
public class Academic {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "id_academy")
	private int idAcademy;
	
	private String name;
	private String status;
	
	@JoinColumn(name="id_user", unique = true)
	@OneToMany(cascade = CascadeType.ALL)
	private java.util.Set<User> users;
	
	@JoinColumn(name="id_courses", unique = true)
	@OneToMany(cascade = CascadeType.ALL)
	private java.util.Set<Courses> courses;

	public Academic() {
		super();
	}
	

	public Academic(int idAcademy, String name, String status, Set<User> users, Set<Courses> courses) {
		super();
		this.idAcademy = idAcademy;
		this.name = name;
		this.status = status;
		this.users = users;
		this.courses = courses;
	}


	public int getIdAcademy() {
		return idAcademy;
	}

	public void setIdAcademy(int idAcademy) {
		this.idAcademy = idAcademy;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public java.util.Set<User> getUsers() {
		System.out.println("Print del get"+users);
		return users;
	}

	public void setUsers(java.util.Set<User> users) {
		this.users = users;
	}

	public java.util.Set<Courses> getCourses() {
		return courses;
	}

	public void setCourses(java.util.Set<Courses> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Academic [idAcademy=" + idAcademy + ", name=" + name + ", status=" + status + ", users=" + users
				+ ", courses=" + courses + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(idAcademy);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Academic other = (Academic) obj;
		return idAcademy == other.idAcademy;
	}
	
	
	
}

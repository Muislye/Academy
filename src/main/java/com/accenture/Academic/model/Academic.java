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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="academic")
public class Academic {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "id_academy")
	private int idAcademy;
	
	private String name;
	private String status;
	
	@JoinColumn(name="id_user", unique = true)
	@ManyToOne//(cascade = CascadeType.ALL)
	private User users;
	
	@JoinColumn(name="id_courses", unique = true)
	@ManyToOne//(cascade = CascadeType.ALL)
	private Courses courses;

	public Academic() {
		super();
	}
	

	public Academic(int idAcademy, String name, String status, User users, Courses courses) {
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

	public User getUsers() {
		System.out.println("Print del get"+users);
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	public Courses getCourses() {
		return courses;
	}

	public void setCourses(Courses courses) {
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

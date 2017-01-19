package com.courses.components.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Student")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "surname")
	private String surname;
	
	@Column(name = "fname")
	private String fname;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "telephone")
	private String telephone;
	
	@Column(name = "date_registrarion")
	private Date date_registrarion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	@JoinColumn(name = "id_Team")
	private Team id_Team;
	
	public Team getId_Team() {
		return id_Team;
	}

	public void setId_Team(Team id_Team) {
		this.id_Team = id_Team;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Date getDate_registrarion() {
		return date_registrarion;
	}

	public void setDate_registrarion(Date date_registrarion) {
		this.date_registrarion = date_registrarion;
	}

	public Student() {
	}

	public Student(Integer id, String name, String surname, String fname, String email, String telephone, Date date_registrarion, Team id_Team) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.fname = fname;
		this.email = email;
		this.telephone = telephone;
		this.date_registrarion = date_registrarion;
		this.id_Team = id_Team;
	}
}

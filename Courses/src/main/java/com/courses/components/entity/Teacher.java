package com.courses.components.entity;

import java.io.Serializable;

public class Teacher implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String surname;
	private String fname;
	private String telephone;
	private String email;
	
	public Teacher() {
	}

	public Teacher(Integer id, String name, String surname, String fname, String telephone, String email) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.fname = fname;
		this.telephone = telephone;
		this.email = email;
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// @Override
	// public String toString() {
	// return "Teacher [id=" + id + ", name=" + name + ", surname=" + surname +
	// "]";
	// }

}

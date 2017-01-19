package com.courses.components.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Payment")
public class Payment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "id_Payment", fetch = FetchType.EAGER)
	@JsonManagedReference
	private Set<Course> courseForPayment = new HashSet<>();

	public Set<Course> getCourseForPayment() {
		return courseForPayment;
	}

	public void setCourseForPayment(Set<Course> courseForPayment) {
		this.courseForPayment = courseForPayment;
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

	public Payment() {
	}

	public Payment(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

}

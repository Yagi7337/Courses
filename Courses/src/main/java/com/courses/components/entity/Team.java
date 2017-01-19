package com.courses.components.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Team")
public class Team implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private Integer id;
	private String name;
	private Date date_start;
	private Date date_end;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	@JoinColumn(name = "id_Course")
	private Course id_Course;
	
	@OneToMany(mappedBy = "id_Team", fetch = FetchType.EAGER)
	@JsonManagedReference
	private Set<Student> studentForTeam = new HashSet<>();
	
	public Set<Student> getStudentForTeam() {
		return studentForTeam;
	}

	public void setStudentForTeam(Set<Student> studentForTeam) {
		this.studentForTeam = studentForTeam;
	}

	public Course getId_Course() {
		return id_Course;
	}

	public void setId_Course(Course id_Course) {
		this.id_Course = id_Course;
	}
	
	public Date getDate_start() {
		return date_start;
	}

	public void setDate_start(Date date_start) {
		this.date_start = date_start;
	}

	public Date getDate_end() {
		return date_end;
	}

	public void setDate_end(Date date_end) {
		this.date_end = date_end;
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

	public Team() {
	}

	public Team(Integer id, String name, Date date_start, Date date_end, Course id_Course) {
		this.id = id;
		this.name = name;
		this.date_start = date_start;
		this.date_end = date_end;
		this.id_Course = id_Course;
	}
}

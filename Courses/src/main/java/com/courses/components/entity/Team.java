package com.courses.components.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Team")
public class Team implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name")
	private String name;
	
	@Column(name = "date_start")
	private Date date_start;
	
	@Column(name = "date_end")
	private Date date_end;
	
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

	@Column(name = "id_Course")
	private Integer id_Course;

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
	public Integer getId_Course() {
		return id_Course;
	}

	public void setId_Course(Integer id_Course) {
		this.id_Course = id_Course;
	}

	public Team() {
	}

	public Team(Integer id, String name, Date date_start, Date date_end, Integer id_Course) {
		this.id = id;
		this.name = name;
		this.date_start = date_start;
		this.date_end = date_end;
		this.id_Course = id_Course;
	}
}
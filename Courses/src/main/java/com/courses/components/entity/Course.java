package com.courses.components.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Course")
public class Course implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "count_week")
	private Integer count_week;
	
	@Column(name = "count_lesson_week")
	private Float count_lesson_week;
	
	@Column(name = "price_month")
	private Float price_month;
	
	@Column(name = "id_Payment")
	private Integer id_Payment;
	
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

	public Integer getCount_week() {
		return count_week;
	}

	public void setCount_week(Integer count_week) {
		this.count_week = count_week;
	}

	public Float getCount_lesson_week() {
		return count_lesson_week;
	}

	public void setCount_lesson_week(Float count_lesson_week) {
		this.count_lesson_week = count_lesson_week;
	}

	public Float getPrice_month() {
		return price_month;
	}

	public void setPrice_month(Float price_month) {
		this.price_month = price_month;
	}

	public Integer getId_Payment() {
		return id_Payment;
	}

	public void setId_Payment(Integer id_Payment) {
		this.id_Payment = id_Payment;
	}

	public Course() {
	}

	public Course(Integer id, String name, Integer count_week,  Float count_lesson_week, Float price_month, Integer id_Payment) {
		this.id = id;
		this.name = name;
		this.count_week = count_week;
		this.count_lesson_week = count_lesson_week;
		this.price_month = price_month;
		this.id_Payment = id_Payment;
	}
}

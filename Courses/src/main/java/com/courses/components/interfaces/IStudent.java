package com.courses.components.interfaces;

import java.util.List;

import com.courses.components.entity.Student;

public interface IStudent {
	public void createStudent(Student student);

	public List<Student> readAllStudent();

	public void updateStudent(Integer id, Student student);

	public void deleteStudent(Integer id);

	public Student getByIdStudent(Integer id);

}

package com.courses.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courses.components.entity.Student;
import com.courses.components.interfaces.IStudent;

@Service
public class StudentService {
	@Autowired
	IStudent iStudent;
	
	public void createStudent(Student student){
		iStudent.createStudent(student);
	}
	
	public List<Student> readAllStudent() {		
		return iStudent.readAllStudent();
	}

	public void updateStudent(Integer id, Student student){
		iStudent.updateStudent(id, student);
	}

	public void deleteStudent(Integer id){
		iStudent.deleteStudent(id);
	}
	
	public Student getByIdStudent(Integer id){
		return iStudent.getByIdStudent(id);
	}
}

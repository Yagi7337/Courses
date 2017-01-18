package com.courses.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.courses.components.entity.Student;
import com.courses.service.StudentService;

@RestController
@RequestMapping(value = "/student")
public class StudentController {
	@Autowired
	StudentService studentService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public void createStudent(@RequestBody Student student) {
		studentService.createStudent(student);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Student> readAllStudent() {
		return studentService.readAllStudent();
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public void updateStudent(@PathVariable("id") Integer id, @RequestBody Student student) {
		studentService.updateStudent(id, student);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void deleteStudent(@PathVariable("id") Integer id) {
		studentService.deleteStudent(id);
	}

	@RequestMapping(value = "/search/{id}", method = RequestMethod.GET)
	public Student getByIdStudent(@PathVariable("id") Integer id) {
		return studentService.getByIdStudent(id);
	}	
}

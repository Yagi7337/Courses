package com.courses.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.courses.components.entity.Teacher;
import com.courses.service.TeacherService;

@RestController
@RequestMapping(value = "/teacher")
public class TeacherController {

	@Autowired
	TeacherService teacherService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public void createTeacher(@RequestBody Teacher teacher) {
		teacherService.createTeacher(teacher);
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public List<Teacher> readALlTeacher() {
		return teacherService.readAllTeacher();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void updateTeacher(@PathVariable("id") Integer id, @RequestBody Teacher teacher) {
		teacherService.updateTeacher(id, teacher);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteTeacher(@PathVariable("id") Integer id) {
		teacherService.deleteTeacher(id);
	}

	// @RequestMapping(value="/{id}", method = RequestMethod.GET)
	// public Teacher getAll(@PathVariable("id") Integer id){
	// return teacherService.getById(id);
	// }

}

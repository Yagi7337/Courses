package com.courses.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.courses.components.entity.Teacher;
import com.courses.components.entity.Team;
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

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Teacher> readALlTeacher() {
		return teacherService.readAllTeacher();
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public void updateTeacher(@PathVariable("id") Integer id, @RequestBody Teacher teacher) {
		teacherService.updateTeacher(id, teacher);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void deleteTeacher(@PathVariable("id") Integer id) {
		teacherService.deleteTeacher(id);
	}

	@RequestMapping(value = "/search/{id}", method = RequestMethod.GET)
	public Teacher getByIdTeacher(@PathVariable("id") Integer id) {
		return teacherService.getByIdTeacher(id);
	}

}

package com.courses.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.courses.components.entity.Course;
import com.courses.components.entity.Team;
import com.courses.service.CourseService;

@RestController
@RequestMapping(value = "/course")
public class CourseController {
	@Autowired
	CourseService courseService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public void createCourse(@RequestBody Course course) {
		courseService.createCourse(course);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Course> readAllCourse() {
		return courseService.readAllCourse();
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public void updateCourse(@PathVariable("id") Integer id, @RequestBody Course course) {
		courseService.updateCourse(id, course);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void deleteCourse(@PathVariable("id") Integer id) {
		courseService.deleteCourse(id);
	}

	@RequestMapping(value = "/search/{id}", method = RequestMethod.GET)
	public Course getByIdCourse(@PathVariable("id") Integer id) {
		return courseService.getByIdCourse(id);
	}

	@RequestMapping(value = "/team/{id}", method = RequestMethod.GET)
	public Set<Team> getAllTeam(@PathVariable("id") int id) {
		return courseService.getAllTeam(id);
	}

}

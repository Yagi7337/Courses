package com.courses.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courses.components.entity.Course;
import com.courses.components.interfaces.ICourse;

@Service
public class CourseService {
	@Autowired
	ICourse iCourse;
	
	public void createCourse(Course course){
		iCourse.createCourse(course);
	}
	
	public List<Course> readAllCourse() {		
		return iCourse.readAllCourse();
	}

	public void updateCourse(Integer id, Course course){
		iCourse.updateCourse(id, course);
	}

	public void deleteCourse(Integer id){
		iCourse.deleteCourse(id);
	}
	
	public Course getByIdCourse(Integer id){
		return iCourse.getByIdCourse(id);
	}
}

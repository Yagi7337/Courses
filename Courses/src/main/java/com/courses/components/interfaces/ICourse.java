package com.courses.components.interfaces;

import java.util.List;

import com.courses.components.entity.Course;

public interface ICourse {
		public void createCourse(Course course);

		public List<Course> readAllCourse();

		public void updateCourse(Integer id, Course course);

		public void deleteCourse(Integer id);

		public Course getByIdCourse(Integer id);
}

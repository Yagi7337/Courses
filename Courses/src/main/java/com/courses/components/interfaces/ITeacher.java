package com.courses.components.interfaces;

import java.util.List;

import com.courses.components.entity.Teacher;

public interface ITeacher {
	public void createTeacher(Teacher teacher);
	public List<Teacher> readAllTeacher();
	public void updateTeacher(Integer id, Teacher teacher);
	public void deleteTeacher(Integer id);
//	public Teacher getById(Integer id);

}

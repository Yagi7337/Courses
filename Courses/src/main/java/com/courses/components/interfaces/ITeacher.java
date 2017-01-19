package com.courses.components.interfaces;

import java.util.List;
import java.util.Set;

import com.courses.components.entity.Teacher;
import com.courses.components.entity.Team;

public interface ITeacher {
	public void createTeacher(Teacher teacher);

	public List<Teacher> readAllTeacher();

	public void updateTeacher(Integer id, Teacher teacher);

	public void deleteTeacher(Integer id);

	public Teacher getByIdTeacher(Integer id);
	
	public Set<Team> getAllTeam(int id);
	
}

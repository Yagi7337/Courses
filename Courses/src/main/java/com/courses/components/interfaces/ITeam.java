package com.courses.components.interfaces;

import java.util.List;
import java.util.Set;

import com.courses.components.entity.Course;
import com.courses.components.entity.Student;
import com.courses.components.entity.Teacher;
import com.courses.components.entity.Team;

public interface ITeam {
	public void createTeam(Team team);

	public List<Team> readAllTeam();

	public void updateTeam(Integer id, Team team);

	public void deleteTeam(Integer id);

	public Team getByIdTeam(Integer id);
	
	public Set<Student> getAllStudent(int id);
	
}

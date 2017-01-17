package com.courses.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courses.components.entity.Teacher;
import com.courses.components.interfaces.ITeacher;

@Service
public class TeacherService {
	@Autowired
	ITeacher iTeacher;
	
	public void createTeacher(Teacher teacher){
		iTeacher.createTeacher(teacher);
	}
	
	public List<Teacher> readAllTeacher() {		
		return iTeacher.readAllTeacher();
	}

	public void updateTeacher(Integer id, Teacher teacher){
		iTeacher.updateTeacher(id, teacher);
	}

	public void deleteTeacher(Integer id){
		iTeacher.deleteTeacher(id);
	}
	
//	public Teacher getById(Integer id){
//		return iTeacherDao.getById(id);
//	}

}

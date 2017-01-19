package com.courses.components.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.courses.components.interfaces.ITeacher;
import com.courses.components.persistence.HibernateUtil;
import com.courses.components.entity.Teacher;
import com.courses.components.entity.Team;

@Repository
public class TeacherDao implements ITeacher {
	@Override
	public void createTeacher(Teacher teacher) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(new Teacher(teacher.getId(), teacher.getName(), teacher.getSurname(), teacher.getFname(),
				teacher.getTelephone(), teacher.getEmail()));
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
	}

	@Override
	public List<Teacher> readAllTeacher() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query SQLQuery = session.createQuery("select t from Teacher t");
		ArrayList<Teacher> result = (ArrayList<Teacher>) SQLQuery.list();
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		return result;
	}

	@Override
	public void updateTeacher(Integer id, Teacher teacher) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Teacher update = (Teacher) session.get(Teacher.class, id);
		update.setName(teacher.getName());
		update.setSurname(teacher.getSurname());
		session.update(update);
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}

	}

	@Override
	public void deleteTeacher(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Teacher del = (Teacher) session.get(Teacher.class, id);
		session.delete(del);
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
	}

	@Override
	public Teacher getByIdTeacher(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Teacher result = (Teacher) session.get(Teacher.class, id);
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Set<Team> getAllTeam(int id) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Teacher teacher = (Teacher) session.get(Teacher.class, id);
			session.getTransaction().commit();
			return teacher.getTeams();
		} catch (Exception e) {
			throw e;
		}
	}
}

package com.courses.components.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.courses.components.entity.Course;
import com.courses.components.entity.Payment;
import com.courses.components.entity.Team;
import com.courses.components.interfaces.ICourse;
import com.courses.components.persistence.HibernateUtil;

@Repository
public class CourseDao implements ICourse{
	@Override
	public void createCourse(Course course) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(new Course(course.getId(), course.getName(), course.getCount_week(), course.getCount_lesson_week(), course.getPrice_month(), course.getId_Payment()));
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
	}

	@Override
	public List<Course> readAllCourse() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query SQLQuery = session.createQuery("select t from Course t");
		ArrayList<Course> result = (ArrayList<Course>) SQLQuery.list();
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		return result;
	}

	@Override
	public void updateCourse(Integer id, Course course) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Course update = (Course) session.get(Course.class, id);
		update.setName(course.getName());
		update.setCount_week(course.getCount_week());
		update.setCount_lesson_week(course.getCount_lesson_week());
		update.setPrice_month(course.getPrice_month());
		update.setId_Payment(course.getId_Payment());
		session.update(update);
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}

	}

	@Override
	public void deleteCourse(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Course del = (Course) session.get(Course.class, id);
		session.delete(del);
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
	}

	 @Override
	 public Course getByIdCourse(Integer id) {
	 Session session = HibernateUtil.getSessionFactory().openSession();
	 session.beginTransaction();
	 Course result = (Course) session.get(Course.class, id);
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
			Course course = (Course) session.get(Course.class, id);
			session.getTransaction().commit();
			return course.getTeamForCourse();
		} catch (Exception e) {
			throw e;
		}
	}
}

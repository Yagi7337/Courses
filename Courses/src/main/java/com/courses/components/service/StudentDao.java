package com.courses.components.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.courses.components.entity.Student;
import com.courses.components.interfaces.IStudent;
import com.courses.components.persistence.HibernateUtil;

@Repository
public class StudentDao implements IStudent{
	@Override
	public void createStudent(Student student) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(new Student(student.getId(), student.getName(), student.getSurname(), student.getFname(), student.getEmail(), student.getTelephone(), student.getDate_registrarion(), student.getId_Group()));
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
	}

	@Override
	public List<Student> readAllStudent() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query SQLQuery = session.createQuery("select t from Student t");
		ArrayList<Student> result = (ArrayList<Student>) SQLQuery.list();
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		return result;
	}

	@Override
	public void updateStudent(Integer id, Student student) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Student update = (Student) session.get(Student.class, id);
		update.setName(student.getName());
		update.setSurname(student.getSurname());
		update.setFname(student.getFname());
		update.setEmail(student.getEmail());
		update.setTelephone(student.getTelephone());
		update.setDate_registrarion(student.getDate_registrarion());
		update.setId_Group(student.getId_Group());
		session.update(update);
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}

	}

	@Override
	public void deleteStudent(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Student del = (Student) session.get(Student.class, id);
		session.delete(del);
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
	}

	 @Override
	 public Student getByIdStudent(Integer id) {
	 Session session = HibernateUtil.getSessionFactory().openSession();
	 session.beginTransaction();
	 Student result = (Student) session.get(Student.class, id);
	 session.getTransaction().commit();
	 if (session.isOpen()) {
	 session.close();
	 }
	 return result;
	 }
}

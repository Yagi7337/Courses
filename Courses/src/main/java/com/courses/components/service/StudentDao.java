package com.courses.components.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.courses.components.entity.Student;
import com.courses.components.interfaces.IStudent;
import com.courses.components.persistence.HibernateUtil;

@Repository
public class StudentDao implements IStudent {
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void createStudent(Student student) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(student);
			session.getTransaction().commit();
		} catch (Exception e) {
			// Транзакція буде зупинена
			throw e;
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public List<Student> readAllStudent() {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Query SQLQuery = session.createQuery("select t from Student t");
			ArrayList<Student> result = (ArrayList<Student>) SQLQuery.list();
			session.getTransaction().commit();
			return result;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void updateStudent(Integer id, Student student) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
//			session.beginTransaction();
			Student update = (Student) session.get(Student.class, id);
			update.setName(student.getName());
			update.setSurname(student.getSurname());
			update.setFname(student.getFname());
			update.setEmail(student.getEmail());
			update.setTelephone(student.getTelephone());
			update.setDate_registrarion(student.getDate_registrarion());
			update.setId_Group(student.getId_Group());
			session.update(update);
//			session.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteStudent(Integer id) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Student del = (Student) session.get(Student.class, id);
			session.delete(del);
			session.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Student getByIdStudent(Integer id) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Student result = (Student) session.get(Student.class, id);
			return result;
		} catch (Exception e) {
			throw e;
		}
	}
}

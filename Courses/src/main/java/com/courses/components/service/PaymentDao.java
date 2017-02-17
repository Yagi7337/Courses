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
import com.courses.components.interfaces.IPayment;
import com.courses.components.persistence.HibernateUtil;

@Repository
public class PaymentDao implements IPayment{
	@Override
	public void createPayment(Payment payment) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(new Payment(payment.getId(), payment.getName()));
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
	}

	@Override
	public List<Payment> readAllPayment() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query SQLQuery = session.createQuery("select t from Payment t");
		ArrayList<Payment> result = (ArrayList<Payment>) SQLQuery.list();
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		return result;
	}

	@Override
	public void updatePayment(Integer id, Payment payment) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Payment update = (Payment) session.get(Payment.class, id);
		update.setName(payment.getName());
		session.update(update);
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}

	}

	@Override
	public void deletePayment(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Payment del = (Payment) session.get(Payment.class, id);
		session.delete(del);
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
	}

	 @Override
	 public Payment getByIdPayment(Integer id) {
	 Session session = HibernateUtil.getSessionFactory().openSession();
	 session.beginTransaction();
	 Payment result = (Payment) session.get(Payment.class, id);
	 session.getTransaction().commit();
	 if (session.isOpen()) {
	 session.close();
	 }
	 return result;
	 }
	 
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Set<Course> getAllCourse(int id) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Payment payment = (Payment) session.get(Payment.class, id);
			session.getTransaction().commit();
			return payment.getCourseForPayment();
			
		} catch (Exception e) {
				throw e;
		}
	}
}

package com.courses.components.interfaces;

import java.util.List;
import java.util.Set;

import com.courses.components.entity.Course;
import com.courses.components.entity.Payment;

public interface IPayment {
	public void createPayment(Payment payment);

	public List<Payment> readAllPayment();

	public void updatePayment(Integer id, Payment payment);

	public void deletePayment(Integer id);

	public Payment getByIdPayment(Integer id);
	
	public Set<Course> getAllCourse(int id);
}

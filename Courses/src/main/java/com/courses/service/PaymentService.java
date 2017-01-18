package com.courses.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courses.components.entity.Payment;
import com.courses.components.interfaces.IPayment;

@Service
public class PaymentService {
	@Autowired
	IPayment iPayment;
	
	public void createPayment(Payment payment){
		iPayment.createPayment(payment);
	}
	
	public List<Payment> readAllPayment() {		
		return iPayment.readAllPayment();
	}

	public void updatePayment(Integer id, Payment payment){
		iPayment.updatePayment(id, payment);
	}

	public void deletePayment(Integer id){
		iPayment.deletePayment(id);
	}
	
	public Payment getByIdPayment(Integer id){
		return iPayment.getByIdPayment(id);
	}
}

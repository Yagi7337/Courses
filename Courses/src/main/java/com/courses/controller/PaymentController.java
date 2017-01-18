package com.courses.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.courses.components.entity.Payment;
import com.courses.service.PaymentService;

@RestController
@RequestMapping(value = "/payment")
public class PaymentController {

	@Autowired
	PaymentService paymentService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public void createPayment(@RequestBody Payment payment) {
		paymentService.createPayment(payment);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Payment> readAllPayment() {
		return paymentService.readAllPayment();
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public void updatePayment(@PathVariable("id") Integer id, @RequestBody Payment payment) {
		paymentService.updatePayment(id, payment);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void deletePayment(@PathVariable("id") Integer id) {
		paymentService.deletePayment(id);
	}

	 @RequestMapping(value="/search/{id}", method = RequestMethod.GET)
	 public Payment getByIdPayment(@PathVariable("id") Integer id){
	 return paymentService.getByIdPayment(id);
	 }

}

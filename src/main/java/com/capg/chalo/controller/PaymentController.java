package com.capg.chalo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.chalo.dto.PaymentDto;
import com.capg.chalo.entity.Payment;
import com.capg.chalo.exception.PaymentNotFoundException;
import com.capg.chalo.service.PaymentServiceImpl;

@RestController
@RequestMapping("/api/v1")
public class PaymentController {
	@Autowired
	public PaymentServiceImpl paymentService;

	@PostMapping("/addPayment")
	public Payment addPayment(@RequestBody PaymentDto paymentDto) {
		Payment payment = PaymentConverter(paymentDto);
		return paymentService.addPayment(payment);
	}

	private Payment PaymentConverter(PaymentDto paymentDto) {
		Payment payment = new Payment();
		payment.setPaymentId(paymentDto.getPaymentId());
		payment.setPaymentType(paymentDto.getPaymentType());
		payment.setAmount(paymentDto.getAmount());
		return payment;
	}

	@PutMapping("/updatePayment")
	public Payment updatePayment(@RequestBody PaymentDto paymentDto) {
		Payment payment = PaymentConverter(paymentDto);
		return paymentService.updatePayment(payment);
	}

	@DeleteMapping("/deletePayment/{paymentId}")
	public Payment deletePayment(@PathVariable("paymentId") long paymentId) throws PaymentNotFoundException {
		return paymentService.deletePayment(paymentId);
	}

	@GetMapping("/payments")
	public List<Payment> showAllPayments() {
		return paymentService.showAllPayments();
	}

}

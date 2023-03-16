package com.capg.chalo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.chalo.entity.Payment;
import com.capg.chalo.entity.User;
import com.capg.chalo.exception.CustomException;
import com.capg.chalo.repository.PaymentRepository;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	public PaymentRepository paymentRepository;
	
	@Override
	public Payment addPayment(Payment payment) {
		return paymentRepository.save(payment);
	}
	
	@Override
	public Payment updatePayment(Payment payment) {
		Optional<Payment> existingPayment = paymentRepository.findById(payment.getPaymentId());
		
		existingPayment.get().setPaymentType(payment.getPaymentType());
		existingPayment.get().setAmount(payment.getAmount());
		
		return paymentRepository.save(existingPayment.get());
	}
	
	@Override
	public Payment deletePayment(Long paymentId) {
		Payment payment;
		
		payment = paymentRepository.findById(paymentId).get();
		paymentRepository.deleteById(paymentId);
		return payment;
		
	}
	
	@Override
	public Payment showPaymentById(Long paymentId) {
		Payment payment;
		if(paymentRepository.existsById(paymentId)) {
		payment = paymentRepository.findById(paymentId).get();
		return payment;
		}
		else {
			throw new CustomException("No payment found with the given ID");
		}
	}
	
	@Override
	public List<Payment> showAllPayments() {
		List<Payment> paymentList = paymentRepository.findAll();
		return paymentList;
	}

	
}

package com.capg.chalo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.chalo.entity.Driver;
import com.capg.chalo.entity.Payment;
import com.capg.chalo.entity.Vehicle;
import com.capg.chalo.exception.PaymentNotFoundException;
import com.capg.chalo.exception.VehicleNotFoundException;
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
//		Optional<Payment> existingPayment = paymentRepository.findById(payment.getPaymentId());
//		
//		existingPayment.get().setPaymentType(payment.getPaymentType());
//		existingPayment.get().setAmount(payment.getAmount());
//		
//		return paymentRepository.save(existingPayment.get());
		Optional<Payment> existingPaymentOptional = paymentRepository.findById(payment.getPaymentId());
		if(existingPaymentOptional.isPresent()) {
			Payment existingPayment = existingPaymentOptional.get();
			existingPayment.setPaymentType(payment.getPaymentType());
     		existingPayment.setAmount(payment.getAmount());
     		return paymentRepository.save(existingPayment);
	}else {
		return null;
	}
		
	}
	
	@Override
	public Payment deletePayment(Long paymentId) throws PaymentNotFoundException {
//		Payment payment;
//		
//		payment = paymentRepository.findById(paymentId).get();
//		paymentRepository.deleteById(paymentId);
//		return payment;
		Optional<Payment> found=paymentRepository.findById(paymentId);
		if(found.isPresent()) {
			paymentRepository.delete(found.get());
			return found.get();
		}else 
			throw new PaymentNotFoundException("Payment not found with ID"  +paymentId);
		
	}
		
	
	
	@Override
	public List<Payment> showAllPayments() {
		List<Payment> paymentList = paymentRepository.findAll();
		return paymentList;
	}
}

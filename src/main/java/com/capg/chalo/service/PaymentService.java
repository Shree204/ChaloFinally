package com.capg.chalo.service;

import com.capg.chalo.entity.Payment;
import com.capg.chalo.exception.PaymentNotFoundException;

import java.util.List;

public interface PaymentService {
	public Payment addPayment(Payment payment);
	public Payment updatePayment(Payment payment);
	public Payment deletePayment(Long paymentId) throws PaymentNotFoundException;
	public List<Payment> showAllPayments();
}

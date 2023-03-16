package com.capg.chalo.service;

import com.capg.chalo.entity.Payment;
import java.util.List;

public interface PaymentService {
	public Payment addPayment(Payment payment);
	public Payment updatePayment(Payment payment);
	public Payment deletePayment(Long paymentId);
	public List<Payment> showAllPayments();
	public Payment showPaymentById(Long paymentId);
}

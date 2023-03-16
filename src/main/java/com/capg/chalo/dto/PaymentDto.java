package com.capg.chalo.dto;

import com.capg.chalo.entity.Payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {
	private long paymentId;

	private String paymentType;
	private int amount;

	public PaymentDto(Payment payment) {
		this.paymentId = payment.getPaymentId();
		this.paymentType = payment.getPaymentType();
		this.amount = payment.getAmount();
	}

}

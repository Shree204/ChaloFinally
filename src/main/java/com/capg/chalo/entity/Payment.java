package com.capg.chalo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.capg.chalo.dto.PaymentDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payment")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long paymentId;

	private String paymentType;
	private int amount;

	public Payment(PaymentDto paymentDto) {
		this.paymentId = paymentDto.getPaymentId();
		this.paymentType = paymentDto.getPaymentType();
		this.amount = paymentDto.getAmount();
	}
}

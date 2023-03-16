package com.capg.chalo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.chalo.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}

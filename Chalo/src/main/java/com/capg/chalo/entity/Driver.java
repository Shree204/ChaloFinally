package com.capg.chalo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Table(name = "drivers")
public class Driver {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private long driverId;
	
	private String driverName;
	private int licenseNo;
	private long mobileNo;
	private String vehicleNo;
	private String vehicleType;
	private String password;
	private String confirmPassword;
	
//	@OneToOne(cascade=CascadeType.ALL)
//	//@JoinColumn(name="payment_id",referencedColumnName="paymentId")
//	private Payment payment;
//	
//	@OneToOne(cascade=CascadeType.ALL)
//	//@JoinColumn(name="vehicle_id",referencedColumnName="vehicleId")
//	private Vehicle vehicle;
//	
//	@OneToOne
//	private Booking booking;
	
	
}

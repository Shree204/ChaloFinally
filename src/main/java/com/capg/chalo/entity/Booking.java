package com.capg.chalo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.capg.chalo.dto.BookingDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "booking")

public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bookingId;

	@Column(name = "otp")
	private int otp;

	@Column(name = "pickup_loc")
	private String pickupLocation;

	@Column(name = "drop_loc")
	private String dropLocation;

	private long driverId;

	private long userId;

	public Booking(BookingDto bookingDto) {
		this.bookingId = bookingDto.getBookingId();
		this.otp = bookingDto.getOtp();
		this.pickupLocation = bookingDto.getPickupLocation();
		this.dropLocation = bookingDto.getDropLocation();
		this.driverId = bookingDto.getDriverId();
		this.userId = bookingDto.getUserId();
	}
}

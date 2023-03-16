package com.capg.chalo.dto;

import com.capg.chalo.entity.Booking;

import lombok.Data;

@Data
public class BookingDto {

	private long bookingId;
	private int otp;
	private String pickupLocation;
	private String dropLocation;
	private long driverId;
	private long userId;

	public BookingDto(Booking booking) {
		this.bookingId = booking.getBookingId();
		this.otp = booking.getOtp();
		this.pickupLocation = booking.getPickupLocation();
		this.dropLocation = booking.getDropLocation();
		this.driverId = booking.getDriverId();
		this.userId = booking.getUserId();
	}
}

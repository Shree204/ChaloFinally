package com.capg.chalo.service;

import java.util.List;

import com.capg.chalo.entity.Booking;

public interface BookingService {

	public abstract Booking addBooking(Booking booking);
	public abstract void updateBooking(Booking booking,long bookingId);
	public abstract void deleteBooking(long bookingId);
	public abstract Booking showBookingById(long bookingId);
	public abstract List<Booking> showAllBookings();
}

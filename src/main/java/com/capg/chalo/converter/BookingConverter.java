package com.capg.chalo.converter;

import org.springframework.stereotype.Component;

import com.capg.chalo.dto.BookingDto;
import com.capg.chalo.entity.Booking;

@Component
public class BookingConverter {

	public BookingDto entityToDto(Booking booking) {
		BookingDto bookingDto = new BookingDto(booking);

		bookingDto.setBookingId(booking.getBookingId());
		bookingDto.setOtp(booking.getOtp());
		bookingDto.setPickupLocation(booking.getPickupLocation());
		bookingDto.setDropLocation(booking.getDropLocation());

		return bookingDto;
	}

	public Booking dtoToEntity(BookingDto bookingDto) {
		Booking booking = new Booking();

		booking.setBookingId(bookingDto.getBookingId());
		booking.setOtp(bookingDto.getOtp());
		booking.setPickupLocation(bookingDto.getPickupLocation());
		booking.setDropLocation(bookingDto.getDropLocation());
		return booking;
	}
}

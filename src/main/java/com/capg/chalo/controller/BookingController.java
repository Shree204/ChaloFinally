package com.capg.chalo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.chalo.dto.BookingDto;
import com.capg.chalo.entity.Booking;
import com.capg.chalo.service.BookingServiceImpl;

//@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class BookingController {

	@Autowired
	BookingServiceImpl bookingServiceImpl;

	@GetMapping("/bookings")
	public List<Booking> getAllBookings() {
		return (bookingServiceImpl.showAllBookings());
	}

	@GetMapping("/bookingById/{bookingId}")
	public Booking getBooking(@PathVariable("bookingId") int bookingId) {
		return (bookingServiceImpl.showBookingById(bookingId));
	}

	@DeleteMapping("/deleteBooking/{bookingId}")
	public void deleteBooking(@PathVariable("bookingId") int bookingId) {
		bookingServiceImpl.deleteBooking(bookingId);
	}

	@PostMapping("/addBooking")
	public void saveBooking(@RequestBody BookingDto bookingDto) {
		Booking booking = BookingConverter(bookingDto);
		bookingServiceImpl.addBooking(booking);
	}

	private Booking BookingConverter(BookingDto bookingDto) {
		Booking booking = new Booking();
		booking.setBookingId(bookingDto.getBookingId());
		booking.setOtp(bookingDto.getOtp());
		booking.setPickupLocation(bookingDto.getPickupLocation());
		booking.setDropLocation(booking.getDropLocation());
		booking.setDriverId(booking.getDriverId());
		booking.setUserId(booking.getUserId());
		return booking;
	}

	@PutMapping("/updateBooking/{bookingId}")
	public void updateBooking(@RequestBody BookingDto bookingDto, @PathVariable long bookingId) {
		Booking booking = BookingConverter(bookingDto);
		bookingServiceImpl.updateBooking(booking, bookingId);
	}
}

package com.capg.chalo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.chalo.entity.Booking;
import com.capg.chalo.service.BookingServiceImpl;

@CrossOrigin(origins= "https://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class BookingController {

	@Autowired
	BookingServiceImpl bookingServiceImpl;	
	
	// api get mapping to retrieve all the bookings from the DB
	@GetMapping("/bookings")
	private List<Booking> getAllBookings()
	{
		return(bookingServiceImpl.showAllBookings());
	}
	
	// api get mapping for a particular booking id
	@GetMapping("/bookingById/{bookingId}")
	private Booking getBooking(@PathVariable("bookingId") int bookingId)
	{
		return(bookingServiceImpl.showBookingById(bookingId));
	}
	
	// api delete mapping to delete a particular booking from the DB
	@DeleteMapping("/deleteBooking/{bookingId}")
	private void deleteBooking(@PathVariable("bookingId") int bookingId)
	{
		bookingServiceImpl.deleteBooking(bookingId);
	}
	
	// api to add a new booking to the DB
	@PostMapping("/addBooking")
	private void saveBooking(@RequestBody Booking booking)
	{
		bookingServiceImpl.addBooking(booking);
	}
	
	// api to update the booking details
	@PutMapping("/updateBooking/{bookingId}")
	private void updateBooking(@RequestBody Booking booking, @PathVariable long bookingId)
	{
		//bookingServiceImpl.addBooking(booking);
		bookingServiceImpl.updateBooking(booking, bookingId);
	}
}

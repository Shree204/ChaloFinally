package com.capg.chalo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capg.chalo.converter.BookingConverter;
import com.capg.chalo.entity.Booking;
import com.capg.chalo.exception.ResourceNotFoundException;
import com.capg.chalo.repository.BookingRepository;

@Service
@Transactional
public class BookingServiceImpl implements BookingService{
	
	private Log LOGGER = LogFactory.getLog(BookingServiceImpl.class);
	
	@Autowired
	BookingRepository bookingRepository;
	
	@Autowired
	BookingConverter bookingConverter;

	// saving a new entity to the DB
	@Override
	public Booking addBooking(Booking booking) {
		Booking book = bookingRepository.save(booking);
		LOGGER.info(book);
		return(book);
	}
	
	//updated the booking details
	@Override
	public void updateBooking(Booking booking, long bookingId) {
		
		//bookingRepository.save(booking);
		//Booking updateBooking = bookingRepository.findById(bookingId).get();
		
//		updateBooking.setOtp(booking.getOtp());
//		updateBooking.setVehicleType(booking.getVehicleType());
//		updateBooking.setDriver(booking.getDriver());
//		updateBooking.setUser(booking.getUser());
		
		bookingRepository.save(booking);
	}

	// delete a particular booking request by Id
	@Override
	public void deleteBooking(long bookingId) {
		
		bookingRepository.deleteById(bookingId);
	}

	// display booking details for a particular record
	@Override
	public Booking showBookingById(long bookingId) {
		
//		return(bookingRepository.findById(bookingId).get());
//		
//		Booking emp = bookingRepository.findById(bookingId)
//				.orElseThrow(()-> new ResourceNotFoundException("Booking not exists with id :"+bookingId));
//		return ResponseEntity.ok(emp);
		
		Optional<Booking> fromRepo = bookingRepository.findById(bookingId);
		Booking book = fromRepo.orElseThrow(() ->  new ResourceNotFoundException("Booking not exists with id :" + bookingId));
		return book;
	}

	// display booking details for all the bookings available
	@Override
	public List<Booking> showAllBookings() {
		
		List<Booking> booking = new ArrayList<Booking>();
		bookingRepository.findAll().forEach(newBooking -> booking.add(newBooking));
		System.out.println("Getting data from mock DB"+booking);
		return(booking);
	}

}

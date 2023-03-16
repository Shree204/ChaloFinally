package com.capg.chalo.service;

//import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.capg.chalo.entity.Booking;
import com.capg.chalo.repository.BookingRepository;
import com.capg.chalo.service.BookingServiceImpl;

//@RunWith(SpringRunner.class)
@SpringBootTest
class BookingServiceTest {
//	@Test
//	void contextLoads() {
//	}
	@Autowired
	private BookingServiceImpl service;

	@MockBean
	private BookingRepository repository;
	
	@Test
	 void getBookingsTest() {
		when(repository.findAll()).thenReturn(Stream
				.of(new Booking(101,1111,"dtp","btm",1,2),new Booking(102,2222,"btm","dtp",3,4)).collect(Collectors.toList()));
		assertEquals(2, service.showAllBookings().size());
	}
	
	@Test
	 void getBookingsByIdTest() {
		long bookingId = 5;
		Booking book = new Booking(101,1111,"dtp","btm",1,2);
		when(repository.findById(bookingId))
			.thenReturn(Optional.of(book));
//				.thenReturn(Stream.of(new Booking(101,1111,null,null,null)).collect(Collectors.toList()));
		Assertions.assertEquals(book, service.showBookingById(bookingId));
	}
	
	@Test
	 void saveBookingTest() {
		Booking booking = new Booking(101,1111,"dtp","btm",1,2);
		when(repository.save(booking)).thenReturn(booking);
		Assertions.assertEquals(booking, service.addBooking(booking));
	}
	
	@Test
	 void deleteBookingByIdTest() {
		long bookingId = 5;
		service.deleteBooking(bookingId);
		verify(repository,times(1)).deleteById(bookingId);
	}
}

package com.capg.chalo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.capg.chalo.dto.BookingDto;
import com.capg.chalo.entity.Booking;

@Repository
@EnableJpaRepositories
public interface BookingRepository extends JpaRepository<Booking, Long>{

}

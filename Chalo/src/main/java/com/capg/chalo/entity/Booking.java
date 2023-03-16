package com.capg.chalo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@Table(name = "booking")

public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bookingId;
	
	@Column(name = "otp")
	private int otp;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_vehicle_id", referencedColumnName = "vehicleId")
	private Vehicle vehicleType;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_driver_id", referencedColumnName = "driverId")
	private Driver driver;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_user_id", referencedColumnName = "userId")
	private User user;
}

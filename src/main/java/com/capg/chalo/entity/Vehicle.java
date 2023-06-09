package com.capg.chalo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.capg.chalo.dto.VehicleDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vehicle")
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long vehicleId;

	private String registrationNo;
	private String vehicleType;

	public Vehicle(VehicleDto vehicleDto) {
		this.vehicleId = vehicleDto.getVehicleId();
		this.registrationNo = vehicleDto.getRegistrationNo();
		this.vehicleType = vehicleDto.getVehicleType();
	}

}

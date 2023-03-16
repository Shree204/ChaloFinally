package com.capg.chalo.dto;

import com.capg.chalo.entity.Vehicle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDto {
	private long vehicleId;

	private String registrationNo;
	private String vehicleType;

	public VehicleDto(Vehicle vehicle) {
		this.vehicleId = vehicle.getVehicleId();
		this.registrationNo = vehicle.getRegistrationNo();
		this.vehicleType = vehicle.getVehicleType();
	}

}

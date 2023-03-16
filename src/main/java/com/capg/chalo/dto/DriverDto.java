package com.capg.chalo.dto;

import com.capg.chalo.entity.Driver;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DriverDto {

	private long driverId;

	private String driverName;
	private int licenseNo;
	private long mobileNo;
	private long vehicleNo;
	private String vehicleType;

	public DriverDto(Driver driver) {
		this.driverId = driver.getDriverId();
		this.driverName = driver.getDriverName();
		this.licenseNo = driver.getLicenseNo();
		this.mobileNo = driver.getMobileNo();
		this.vehicleNo = driver.getVehicleNo();
		this.vehicleType = driver.getVehicleType();

	}

}

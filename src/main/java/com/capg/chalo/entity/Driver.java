package com.capg.chalo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.capg.chalo.dto.DriverDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "drivers")
public class Driver {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long driverId;

	private String driverName;
	private int licenseNo;
	private long mobileNo;
	private long vehicleNo;
	private String vehicleType;

	public Driver(DriverDto driverDto) {
		this.driverId = driverDto.getDriverId();
		this.driverName = driverDto.getDriverName();
		this.licenseNo = driverDto.getLicenseNo();
		this.mobileNo = driverDto.getMobileNo();
		this.vehicleNo = driverDto.getVehicleNo();
		this.vehicleType = driverDto.getVehicleType();
	}

}

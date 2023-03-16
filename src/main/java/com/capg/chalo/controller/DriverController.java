package com.capg.chalo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.chalo.dto.DriverDto;
import com.capg.chalo.entity.Driver;
import com.capg.chalo.exception.DriverNotFoundException;
import com.capg.chalo.service.DriverServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class DriverController {
	@Autowired
	public DriverServiceImpl driverService;

	@PostMapping(value = "/addDriver")
	public Driver addDriver(@RequestBody DriverDto driverDto) {
		Driver driver = DriverConverter(driverDto);
		return driverService.addDriver(driver);
	}

	private Driver DriverConverter(DriverDto driverDto) {
		Driver driver = new Driver();
		driver.setDriverId(driverDto.getDriverId());
		driver.setDriverName(driverDto.getDriverName());
		driver.setLicenseNo(driverDto.getLicenseNo());
		driver.setMobileNo(driverDto.getMobileNo());
		driver.setVehicleNo(driverDto.getVehicleNo());
		driver.setVehicleType(driverDto.getVehicleType());
		return driver;
	}

	@PutMapping("/updateDriver")
	public Driver updateDriver(@PathVariable Long driverId, @RequestBody DriverDto driverDto) throws DriverNotFoundException {
		Driver driver = DriverConverter(driverDto);
		return driverService.updateDriver(driverId,driver);
	}

	@DeleteMapping(value = "/driverById/{driverId}")
	public Driver deleteDriver(@PathVariable("driverId") long driverId) throws DriverNotFoundException {
		return driverService.deleteDriver(driverId);
	}

	@GetMapping(value = "/drivers")
	public List<Driver> showAllDrivers() {
		return driverService.showAllDrivers();
	}

}

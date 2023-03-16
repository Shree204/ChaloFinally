package com.capg.chalo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.chalo.entity.Driver;
import com.capg.chalo.exception.CustomException;
import com.capg.chalo.exception.InvalidMobileOrPasswordException;
import com.capg.chalo.service.DriverServiceImpl;

import java.util.List;

@CrossOrigin(origins= "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class DriverController {
	@Autowired
	public DriverServiceImpl driverService;
	
	@PostMapping(value="/addDriver")
	public Driver addDriver(@RequestBody Driver driver) {
		return driverService.addDriver(driver);
	}
	
	@PutMapping("/updateDriver")
	public Driver updateDriver(@RequestBody Driver driver) {
		return driverService.updateDriver(driver);
	}
	
	@DeleteMapping(value="/driverById/{driverId}")
	public Driver deleteDriver(@PathVariable("driverId")long driverId) {
		return driverService.deleteDriver(driverId);
	}
	
	@GetMapping(value="/drivers")
	public List<Driver> showAllDrivers(){
		return driverService.showAllDrivers();
	}
	
	@PostMapping("/driverLogin")
	public ResponseEntity<Driver> checkLogin(@RequestBody Driver driver) throws InvalidMobileOrPasswordException{
		return new ResponseEntity<Driver>(driverService.findByMobileNoAndPassword(driver.getMobileNo(),driver.getPassword()), HttpStatus.OK);
	}
	
}

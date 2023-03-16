package com.capg.chalo.service;

import com.capg.chalo.entity.Driver;
import com.capg.chalo.exception.CustomException;
import com.capg.chalo.exception.InvalidMobileOrPasswordException;

import java.util.List;

public interface DriverService {
	public Driver addDriver(Driver driver);
	public Driver updateDriver(Driver driver);
	public Driver deleteDriver(long driverId);
	public List<Driver> showAllDrivers();
	public Driver findByMobileNoAndPassword(Long mobileNo,String password) throws InvalidMobileOrPasswordException;
}

package com.capg.chalo.service;

import com.capg.chalo.entity.Driver;
import com.capg.chalo.exception.DriverNotFoundException;

import java.util.List;

public interface DriverService {
	public Driver addDriver(Driver driver);
	public Driver updateDriver(Long driverId, Driver driver) throws DriverNotFoundException  ;
	public Driver deleteDriver(long driverId) throws DriverNotFoundException;
	public List<Driver> showAllDrivers();
}

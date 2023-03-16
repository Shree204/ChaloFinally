package com.capg.chalo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.chalo.entity.Driver;
import com.capg.chalo.entity.Vehicle;
import com.capg.chalo.exception.DriverNotFoundException;
import com.capg.chalo.exception.VehicleNotFoundException;
import com.capg.chalo.repository.DriverRepository;

import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {
	@Autowired
	public DriverRepository driverRepository;
	
	/*
	 * @Author	: Sudeep Ghosh
	 * @Description	: This method is used to add a new driver to the database.
	 * @Param	: It takes driver as a parameter.
	 * @Return	: It returns the saved driver.
	 * @Date created	: 13 Feb 2023
	 */
	
	@Override
	public Driver addDriver(Driver driver) {
		return driverRepository.save(driver);
	}
	
	/*
	 * @Author	: Sudeep Ghosh
	 * @Description	: This is used to update an existing driver.
	 * @Param	: It takes driver and driverId as a parameter.
	 * @Return	: It returns updated driver.
	 * @Date created	: 13 Feb 2023
	 */
	
	@Override
	public Driver updateDriver(Long driverId ,Driver driver) throws DriverNotFoundException{
		
		Optional<Driver> existingDriverOptional = driverRepository.findById(driver.getDriverId());
		if(existingDriverOptional.isPresent()) {
			Driver existingDriver = existingDriverOptional.get();
		
		existingDriver.setDriverName(driver.getDriverName());
		existingDriver.setLicenseNo(driver.getLicenseNo());
		existingDriver.setMobileNo(driver.getMobileNo());
		existingDriver.setVehicleNo(driver.getVehicleNo());
		existingDriver.setVehicleType(driver.getVehicleType());
		return driverRepository.save(existingDriver);
		}else {
			throw new DriverNotFoundException("Driver not found with Id" +driverId);
		}
	}
	
	/*
	 * @Author	: Sudeep Ghosh
	 * @Description	: This is used to update an existing driver.
	 * @Param	: It takes driver ID as a parameter.
	 * @Return	: It returns the driver object.
	 * @Date created	: 13 Feb 2023
	 */
	
	@Override
	public Driver deleteDriver(long driverId) throws DriverNotFoundException{
//		Driver driver;
//		driver = driverRepository.findById(driverId).get();
//		driverRepository.deleteById(driverId);
//		return driver;
		Optional<Driver> found=driverRepository.findById(driverId);
		if(found.isPresent()) {
			driverRepository.delete(found.get());
			return found.get();
		}else 
			throw new DriverNotFoundException("Driver not found with ID"  +driverId);
		
	}
	

	
	/*
	 * @Author	: Sudeep Ghosh
	 * @Description	: This is used to get the list of all drivers.
	 * @Param	: It does not take any parameter.
	 * @Return	: It returns a list of drivers.
	 * @Date created	: 13 Feb 2023
	 */
	
	@Override
	public List<Driver> showAllDrivers(){
		List<Driver> driverList = driverRepository.findAll();
		return driverList;
	}
}

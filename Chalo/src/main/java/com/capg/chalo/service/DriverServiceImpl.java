package com.capg.chalo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.chalo.entity.Driver;
import com.capg.chalo.exception.CustomException;
import com.capg.chalo.exception.InvalidMobileOrPasswordException;
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
		
		driver = driverRepository.save(driver);
		if(driver!=null) {
		return driver;
		}
		else {
			throw new CustomException("The field can't be null");
		}
		
	}
	
	/*
	 * @Author	: Sudeep Ghosh
	 * @Description	: This is used to update an existing driver.
	 * @Param	: It takes driver and driverId as a parameter.
	 * @Return	: It returns updated driver.
	 * @Date created	: 13 Feb 2023
	 */
	
	@Override
	public Driver updateDriver(Driver driver) {
		Optional<Driver> existingDriver = driverRepository.findById(driver.getDriverId());
		if(existingDriver == null) {
			throw new CustomException("Driver not found");
		}
		else {
		existingDriver.get().setDriverName(driver.getDriverName());
		existingDriver.get().setLicenseNo(driver.getLicenseNo());
		existingDriver.get().setMobileNo(driver.getMobileNo());
		existingDriver.get().setVehicleNo(driver.getVehicleNo());
		existingDriver.get().setVehicleType(driver.getVehicleType());
		}
		return driverRepository.save(existingDriver.get());
		
	}
	
	/*
	 * @Author	: Sudeep Ghosh
	 * @Description	: This is used to delete an existing driver.
	 * @Param	: It takes driver ID as a parameter.
	 * @Return	: It returns the driver object.
	 * @Date created	: 13 Feb 2023
	 */
	
	@Override
	public Driver deleteDriver(long driverId){
		Driver driver;
		if(driverRepository.existsById(driverId)) {
		driver = driverRepository.findById(driverId).get();
		driverRepository.deleteById(driverId);
		return driver;
		}
		else {
			throw new CustomException("Driver not found with the given ID");
		}
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
		if(driverList.isEmpty()) {
			throw new CustomException("No Driver Found");
		}
		return driverList;
	}
	
	/*
	 * @Author	: Sudeep Ghosh
	 * @Description	: This is used to get the details of driver to login.
	 * @Param	: It does not takes mobile number and password as a parameter.
	 * @Return	: It returns driver.
	 * @Date created	: 18 Feb 2023
	 */
	
	@Override
	public Driver findByMobileNoAndPassword(Long mobileNo, String password) throws InvalidMobileOrPasswordException  
	{
		Driver result=driverRepository.findByMobileNoAndPassword(mobileNo,password);
		if(result==null) throw new InvalidMobileOrPasswordException("error in ur passsword or mobile");
		return driverRepository.findByMobileNoAndPassword(mobileNo, password);
	}
}

package com.capg.chalo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.chalo.entity.Driver;
import com.capg.chalo.entity.Payment;
import com.capg.chalo.entity.Vehicle;
import com.capg.chalo.exception.DriverNotFoundException;
import com.capg.chalo.exception.VehicleNotFoundException;
import com.capg.chalo.repository.VehicleRepository;

@Service 
public class VehicleServiceImpl implements VehicleService {
	@Autowired
	public VehicleRepository vehicleRepository;
	
	@Override
	public Vehicle addVehicle(Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}
	
	@Override
	public Vehicle updateVehicle(Vehicle vehicle) {
		Optional<Vehicle> existingVehicleOptional = vehicleRepository.findById(vehicle.getVehicleId());
		if(existingVehicleOptional.isPresent()) {
			Vehicle existingVehicle = existingVehicleOptional.get();
		existingVehicle.setVehicleType(vehicle.getVehicleType());
		existingVehicle.setRegistrationNo(vehicle.getRegistrationNo());
		
		
		return vehicleRepository.save(existingVehicle);
	}else {
		return null;
	}
}
	@Override
	public Vehicle deleteVehicle(long vehicleId)throws VehicleNotFoundException {
//		Vehicle vehicle;
//		vehicle = vehicleRepository.findById(vehicleId).get();
//		vehicleRepository.deleteById(vehicleId);
//		return vehicle;
		Optional<Vehicle> found=vehicleRepository.findById(vehicleId);
		if(found.isPresent()) {
			vehicleRepository.delete(found.get());
			return found.get();
		}else 
			throw new VehicleNotFoundException("Vehicle not found with ID"  +vehicleId);
		
	}
	
	@Override
	public Vehicle showVehicleById(long vehicleId) throws VehicleNotFoundException{
//		//Vehicle vehicle;
//		Optional<Vehicle> vehicle = vehicleRepository.findById(vehicle.getVehicleId());
//		return vehicleRepository.save(vehicle.get());
//		//vehicle = vehicleRepository.findById(vehicleId).get();
//		//return vehicle;
		Optional<Vehicle> found=vehicleRepository.findById(vehicleId);
		if(found.isPresent()) {
			return found.get();
		}else 
			throw new VehicleNotFoundException("Vehicle not found with ID"  +vehicleId);
		
	}
	
	@Override
	public List<Vehicle> showAllVehicles(){
		List<Vehicle> vehicleList = vehicleRepository.findAll();
		return vehicleList;
	}
}

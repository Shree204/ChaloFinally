package com.capg.chalo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.capg.chalo.entity.Vehicle;
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
		Optional<Vehicle> existingVehicle = vehicleRepository.findById(vehicle.getVehicleId());
		
		existingVehicle.get().setVehicleType(vehicle.getVehicleType());
		existingVehicle.get().setRegistrationNo(vehicle.getRegistrationNo());
		
		
		return vehicleRepository.save(existingVehicle.get());
	}
	
	@Override
	public Vehicle deleteVehicle(long vehicleId) {
		Vehicle vehicle;
		
		vehicle = vehicleRepository.findById(vehicleId).get();
		vehicleRepository.deleteById(vehicleId);
		return vehicle;
	}
	
	@Override
	public Vehicle showVehicleById(long vehicleId) {
		Vehicle vehicle;
		
		vehicle = vehicleRepository.findById(vehicleId).get();
		return vehicle;
	}
	
	@Override
	public List<Vehicle> showAllVehicles(){
		List<Vehicle> vehicleList = vehicleRepository.findAll();
		return vehicleList;
	}
}

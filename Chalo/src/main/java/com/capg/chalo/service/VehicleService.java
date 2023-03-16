package com.capg.chalo.service;

import java.util.List;


import com.capg.chalo.entity.Vehicle;

public interface VehicleService {
	public Vehicle addVehicle(Vehicle vehicle);
	public Vehicle updateVehicle(Vehicle vehicle);
	public Vehicle deleteVehicle(long vehicleId);
	public Vehicle showVehicleById(long vehicleId);
	public List<Vehicle> showAllVehicles();
}

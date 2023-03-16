package com.capg.chalo.service;

import java.util.List;


import com.capg.chalo.entity.Vehicle;
import com.capg.chalo.exception.VehicleNotFoundException;

public interface VehicleService {
	public Vehicle addVehicle(Vehicle vehicle);
	public Vehicle updateVehicle(Vehicle vehicle);
	public Vehicle deleteVehicle(long vehicleId) throws VehicleNotFoundException;
	public Vehicle showVehicleById(long vehicleId)throws VehicleNotFoundException;
	public List<Vehicle> showAllVehicles();
}

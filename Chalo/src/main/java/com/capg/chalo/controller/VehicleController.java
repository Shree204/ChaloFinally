package com.capg.chalo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.chalo.entity.Vehicle;
import com.capg.chalo.service.VehicleServiceImpl;

@CrossOrigin(origins= "https://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class VehicleController {
	@Autowired
	public VehicleServiceImpl vehicleService;
	
	@PostMapping("/addVehicle")
	public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
		return vehicleService.addVehicle(vehicle);
	}
	
	@PutMapping("/updateVehicle")
	public Vehicle updateVehicle(@RequestBody Vehicle vehicle) {
		return vehicleService.updateVehicle(vehicle);
	}
	
	@DeleteMapping("/deleteVehicle/{vehicleId}")
	public Vehicle deleteVehicle(@PathVariable("vehicleId") long vehicleId) {
		return vehicleService.deleteVehicle(vehicleId);
	}
	
	@GetMapping("/vehicleById/{vehicleId}")
	public Vehicle showVehicleById(@PathVariable("vehicleId") long vehicleId) {
		return vehicleService.showVehicleById(vehicleId);
	}
	
	@GetMapping("/vehicles")
	public List<Vehicle> showAllVehicles() {
		return vehicleService.showAllVehicles();
	}

}

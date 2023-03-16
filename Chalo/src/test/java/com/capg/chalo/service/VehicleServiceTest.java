package com.capg.chalo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.chalo.entity.Vehicle;
import com.capg.chalo.exception.VehicleNotFoundException;
import com.capg.chalo.repository.VehicleRepository;
import com.capg.chalo.service.VehicleService;
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class VehicleServiceTest {

	@Autowired
	public VehicleRepository vehicleRepository;
	@Autowired
	public VehicleService vehicleService;
	
	@Test
	@Order(1)
	void testAddVehicle() {
		Vehicle vehicle = new Vehicle();
		vehicle.setRegistrationNo("123ab");
		vehicle.setVehicleType("car");
		vehicleRepository.save(vehicle);
		assertNotNull(vehicleRepository.findById(3l).get());
		
	}
	
	@Test
	@Order(2)
	void testGetVehicle() throws VehicleNotFoundException {
		Vehicle vehicle = new Vehicle();
		vehicle = vehicleService.showVehicleById(3L);
		assertNotNull(vehicle);
	}
	
	@Test
	@Order(3)
	void testGetAllVehicle() {
		assertNotNull(vehicleService.showAllVehicles());
		
	}
	
	@Test
	@Order(4)
	void testUpdateVehicle() {
		Vehicle vehicle = vehicleRepository.findById(3L).get();
		vehicle.setRegistrationNo("123dc");
		vehicle.setVehicleType("bike");
		vehicleRepository.save(vehicle);
		assertNotNull("123ab", vehicleRepository.findById(3L).get().getRegistrationNo());
		assertNotNull("car", vehicleRepository.findById(3L).get().getVehicleType());
	}
	
	@Test
	@Order(5)
	void testDeleteByVehicleId() {
		vehicleRepository.deleteById(3L);
		assertThat(vehicleRepository.existsById(3L)).isFalse();
		
	  
	}
	
	@Test
	@Order(6)
	void testDeleteAllVehicle() {
		assertNotNull(vehicleService.showAllVehicles());
	}

}

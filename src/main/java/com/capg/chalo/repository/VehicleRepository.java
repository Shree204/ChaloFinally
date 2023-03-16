package com.capg.chalo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.capg.chalo.entity.Vehicle;

@Repository
@EnableJpaRepositories
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

}

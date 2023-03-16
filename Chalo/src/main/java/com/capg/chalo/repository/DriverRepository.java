package com.capg.chalo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.capg.chalo.entity.Driver;

@Repository
@EnableJpaRepositories
public interface DriverRepository extends JpaRepository<Driver, Long> {
	public Driver findByMobileNoAndPassword(Long mobileNo,String password);
}

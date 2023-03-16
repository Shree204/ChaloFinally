package com.capg.chalo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.chalo.entity.Driver;
import com.capg.chalo.entity.Payment;
import com.capg.chalo.entity.User;
import com.capg.chalo.entity.Vehicle;
import com.capg.chalo.exception.DriverNotFoundException;
import com.capg.chalo.exception.UserNotFoundException;
import com.capg.chalo.exception.VehicleNotFoundException;
import com.capg.chalo.repository.UserRepository;

import java.util.List;


@Service
public class UserServiceImpl implements UserService{
	@Autowired
	public UserRepository userRepository;
	
	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}
	
	@Override
	public User updateUser(User user) {
		Optional<User> existingUserOptional = userRepository.findById(user.getUserId());
		if(existingUserOptional.isPresent()) {
			User existingUser = existingUserOptional.get();
		existingUser.setUserName(user.getUserName());
		existingUser.setPassword(user.getPassword());
		existingUser.setConfirmPassword(user.getConfirmPassword());
		existingUser.setMobileNo(user.getMobileNo());
		
		return userRepository.save(existingUser);
	}else {
		return null;
	}
}
	@Override
	public User deleteUser(long userId) throws UserNotFoundException {
//		User user;
//		user = userRepository.findById(userId).get();
//		userRepository.deleteById(userId);
//		return user;
		Optional<User> found=userRepository.findById(userId);
		if(found.isPresent()) {
			userRepository.delete(found.get());
			return found.get();
		}else 
			throw new UserNotFoundException("Driver not found with ID"  +userId);
		
	}
	
	
	@Override
	public User showUserById(long userId) throws UserNotFoundException{
//		User user;
//		user = userRepository.findById(userId).get();
//		return user;
		Optional<User> found=userRepository.findById(userId);
		if(found.isPresent()) {
			return found.get();
		}else 
			throw new UserNotFoundException("User not found with ID"  +userId);
	}
	
	@Override
	public List<User> showAllUsers(){
		List<User> userList = userRepository.findAll();
		return userList;
	}
}

package com.capg.chalo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.chalo.entity.Driver;
import com.capg.chalo.entity.User;
import com.capg.chalo.exception.CustomException;
import com.capg.chalo.exception.InvalidMobileOrPasswordException;
import com.capg.chalo.service.UserServiceImpl;

import java.util.List;

@CrossOrigin(origins= "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class UserController {
	@Autowired
	public UserServiceImpl userService;
	
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@PutMapping("/updateUser")
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}
	
	@DeleteMapping("/deleteUser/{userId}")
	public User deleteUser(@PathVariable("userId") long userId) {
		return userService.deleteUser(userId);
	}
	
	@GetMapping("/userById/{userId}")
	public User showUserById(@PathVariable("userId") long userId) {
		return userService.showUserById(userId);
	}
	
	@GetMapping("/users")
	public List<User> showAllUsers() {
		return userService.showAllUsers();
	}
	
	@PostMapping("/userLogin")
	public ResponseEntity<User> checkLogin(@RequestBody User user) throws InvalidMobileOrPasswordException {
		return new ResponseEntity<User>(userService.findByMobileNoAndPassword(user.getMobileNo(),user.getPassword()), HttpStatus.OK);
	}

}

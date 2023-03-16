package com.capg.chalo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.chalo.dto.UserDto;
import com.capg.chalo.entity.User;
import com.capg.chalo.exception.UserNotFoundException;
import com.capg.chalo.service.UserServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {
	@Autowired
	public UserServiceImpl userService;

	@PostMapping("/addUser")
	public User addUser(@RequestBody UserDto userDto) {
		User user = UserConverter(userDto);
		return userService.addUser(user);
	}

	private User UserConverter(UserDto userDto) {
		User user = new User();
		user.setUserId(userDto.getUserId());
		user.setUserName(userDto.getUserName());
		user.setPassword(userDto.getPassword());
		user.setConfirmPassword(userDto.getConfirmPassword());
		user.setMobileNo(userDto.getMobileNo());
		return user;
	}

	@PutMapping("/updateUser")
	public User updateUser(@RequestBody UserDto userDto) {
		User user = UserConverter(userDto);
		return userService.updateUser(user);
	}

	@DeleteMapping("/deleteUser/{userId}")
	public User deleteUser(@PathVariable("userId") long userId) throws UserNotFoundException {
		return userService.deleteUser(userId);
	}

	@GetMapping("/userById/{userId}")
	public User showUserById(@PathVariable("userId") long userId) throws UserNotFoundException {
		return userService.showUserById(userId);
	}

	@GetMapping("/users")
	public List<User> showAllUsers() {
		return userService.showAllUsers();
	}

}

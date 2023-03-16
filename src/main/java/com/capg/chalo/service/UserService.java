package com.capg.chalo.service;

import java.util.List;

import com.capg.chalo.entity.User;
import com.capg.chalo.exception.UserNotFoundException;

public interface UserService {
	public User addUser(User user);
	public User updateUser(User user);
	public User deleteUser(long userId) throws UserNotFoundException;
	public User showUserById(long userId) throws UserNotFoundException;
	public List<User> showAllUsers();
}

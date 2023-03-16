package com.capg.chalo.service;

import java.util.List;

import com.capg.chalo.entity.Driver;
import com.capg.chalo.entity.User;
import com.capg.chalo.exception.CustomException;
import com.capg.chalo.exception.InvalidMobileOrPasswordException;

public interface UserService {
	public User addUser(User user);
	public User updateUser(User user);
	public User deleteUser(long userId);
	public User showUserById(long userId);
	public List<User> showAllUsers();
	public User findByMobileNoAndPassword(Long mobileNo,String password) throws InvalidMobileOrPasswordException ;
}

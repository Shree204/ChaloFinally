package com.capg.chalo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.chalo.entity.Driver;
import com.capg.chalo.entity.User;
import com.capg.chalo.exception.CustomException;
import com.capg.chalo.exception.InvalidMobileOrPasswordException;
import com.capg.chalo.repository.UserRepository;

import java.util.List;


@Service
public class UserServiceImpl implements UserService{
	@Autowired
	public UserRepository userRepository;
	
	/*
	 * @Author	: Ishika Galav
	 * @Description	: This method is used to add a new user to the database.
	 * @Param	: It takes user as a parameter.
	 * @Return	: It returns the saved user.
	 * @Date created	: 13 Feb 2023
	 */

	
	@Override
	public User addUser(User user) throws CustomException {
	
		user = userRepository.save(user);
		return user;
		
		
	}
	
	/*
	 * @Author	: Ishika Galav
	 * @Description	: This is used to update an existing user.
	 * @Param	: It takes user and userId as a parameter.
	 * @Return	: It returns updated user.
	 * @Date created	: 13 Feb 2023
	 */

	
	@Override
	public User updateUser(User user) {
		Optional<User> existingUser = userRepository.findById(user.getUserId());
		
		existingUser.get().setUserName(user.getUserName());
		existingUser.get().setPassword(user.getPassword());
		existingUser.get().setConfirmPassword(user.getConfirmPassword());
		existingUser.get().setMobileNo(user.getMobileNo());
		
		return userRepository.save(existingUser.get());
	}
	
	/*
	 * @Author	: Ishika Galav
	 * @Description	: This is used to delete an existing user.
	 * @Param	: It takes user ID as a parameter.
	 * @Return	: It returns the user object.
	 * @Date created	: 13 Feb 2023
	 */

	@Override
	public User deleteUser(long userId) {
		User user;
		
		user = userRepository.findById(userId).get();
		userRepository.deleteById(userId);
		return user;

	}
	
	/*
	 * @Author	: Ishika Galav
	 * @Description	: This is used to get the details of particular user by userId.
	 * @Param	: It takes userId as a parameter.
	 * @Return	: It returns a  user.
	 * @Date created	: 13 Feb 2023
	 */

	
	@Override
	public User showUserById(long userId) {
		User user;
		
		user = userRepository.findById(userId).get();
		return user;
	}
	
	/*
	 * @Author	: Ishika Galav
	 * @Description	: This is used to get the list of all users.
	 * @Param	: It does not take any parameter.
	 * @Return	: It returns a list of users.
	 * @Date created	: 13 Feb 2023
	 */

	
	@Override
	public List<User> showAllUsers(){
		List<User> userList = userRepository.findAll();
		return userList;
	}
	
	/*
	 * @Author	: Ishika Galav
	 * @Description	: This is used to get the details of user to login.
	 * @Param	: It does not takes mobile number and password as a parameter.
	 * @Return	: It returns user.
	 * @Date created	: 18 Feb 2023
	 */
	
	@Override
	public User findByMobileNoAndPassword(Long mobileNo, String password) throws InvalidMobileOrPasswordException
	{
		User result=userRepository.findByMobileNoAndPassword(mobileNo,password);
	if(result==null) throw new InvalidMobileOrPasswordException("error in ur passsword or mobile");
		return userRepository.findByMobileNoAndPassword(mobileNo, password);
		

	}
}

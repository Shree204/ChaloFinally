package com.capg.chalo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.capg.chalo.entity.User;
import com.capg.chalo.exception.CustomException;
import com.capg.chalo.exception.EmptyUserListException;
import com.capg.chalo.exception.UserAlreadyExistException;
import com.capg.chalo.repository.UserRepository;

@SpringBootTest
public class UserServiceTest {
	@Autowired
	private UserService userService;
	
	@MockBean
	private UserRepository userRepository;
	
	private User user;
	
	@BeforeEach
	public void userServiceTestSetUp() {
		user = new User(1,"Honey","1762","1762",7865431291L);
		
	}
	
	@Test
	public void addUserTest() throws UserAlreadyExistException {
		Mockito.when(userRepository.save(user)).thenReturn(user);
		assertThat(userService.addUser(user)).isEqualTo(user);
	}
	
	@Test
	public void getAllUsersTest() throws EmptyUserListException {
		List<User> userList = new ArrayList<>();
		userList.add(user);
		Mockito.when(userRepository.findAll()).thenReturn(userList);
		assertThat(userService.showAllUsers()).isEqualTo(userList);
	}
	
	@Test
	public void updateUserTest() throws CustomException{
		Mockito.when(userRepository.save(user)).thenReturn(user);
		Mockito.when(userRepository.findById(1l)).thenReturn(Optional.of(user));
		
		User updatedUser = new User(1l, "Honey","1762","1762",7865431291l);
		User result = userService.updateUser(updatedUser);
		
		assertEquals("Honey",result.getUserName());
		assertEquals("1762",result.getPassword());
		assertEquals(7865431291l,result.getMobileNo());
		
	}
	
	@Test
	public  void getUserByIdTest() throws CustomException{
		Mockito.when(userRepository.findById(1l)).thenReturn(Optional.of(user));
		assertThat(userService.showUserById(1)).isEqualTo(user);
	}
	
//	@Test
//	public void deleteUserTest() throws CustomException{
//		Mockito.when(userRepository.findById(1l)).thenReturn(Optional.of(user));
//		Mockito.doNothing().when(userRepository).deleteById(1l);
//		
//		String result = userService.deleteById(1l));
//		verify(userRepository, times(1)).deleteById(1);
//		
//		assertEquals(result,"User is deleted");
//	}
	
}

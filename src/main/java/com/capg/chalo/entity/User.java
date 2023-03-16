package com.capg.chalo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.capg.chalo.dto.UserDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userId;

	private String userName;
	private String password;
	private String confirmPassword;
	private long mobileNo;

	public User(UserDto userDto) {
		this.userId = userDto.getUserId();
		this.userName = userDto.getUserName();
		this.password = userDto.getPassword();
		this.confirmPassword = userDto.getConfirmPassword();
		this.mobileNo = userDto.getMobileNo();
	}
}

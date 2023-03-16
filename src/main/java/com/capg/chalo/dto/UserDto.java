package com.capg.chalo.dto;

import com.capg.chalo.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	private long userId;

	private String userName;
	private String password;
	private String confirmPassword;
	private long mobileNo;

	public UserDto(User user) {
		this.userId = user.getUserId();
		this.userName = user.getUserName();
		this.password = user.getPassword();
		this.confirmPassword = user.getConfirmPassword();
		this.mobileNo = user.getMobileNo();
	}

}

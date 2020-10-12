package com.binay.userdetails.util;

import com.binay.userdetails.persistence.entity.User;
import com.binay.userdetails.rest.dto.UserDto;

public class UserUtil {
	
	public static UserDto toUserDto(User user) {
		
		UserDto userDto = UserDto.builder()
				.address(user.getAddress())
				.firstn(user.getFirstn())
				.gender(user.getGender())
				.lastname(user.getLastName())
				.title(user.getTitle())
				.build();
		
		return userDto;
		
	}
	
	public static User toUser(User user, UserDto userDto) {
		
		user.setFirstn(userDto.getFirstn());
		user.setLastName(userDto.getLastname());
		user.setGender(userDto.getGender());
		user.setTitle(userDto.getTitle());
		user.setAddress(userDto.getAddress());
		return user;
	}

}

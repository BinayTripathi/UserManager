package com.binay.userdetails.service;

import com.binay.userdetails.rest.dto.UserDto;

public interface UserService {
	
	public UserDto getUser(Integer user_id);
	
	public void updateUser(Integer userId, UserDto userDto);

}

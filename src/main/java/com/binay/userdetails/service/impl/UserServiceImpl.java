package com.binay.userdetails.service.impl;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binay.userdetails.exception.UserNotFoundException;
import com.binay.userdetails.persistence.entity.User;
import com.binay.userdetails.persistence.repository.UserRepository;
import com.binay.userdetails.rest.dto.UserDto;
import com.binay.userdetails.service.UserService;
import com.binay.userdetails.util.UserUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	public UserDto getUser(Integer user_id) {
		 User user = userRepository.getUserByUserId(user_id)
				.orElseThrow(() -> new UserNotFoundException("No User found with id :" + user_id));
		 
		 UserDto userDto = UserUtil.toUserDto(user);
		 return userDto;
	}
	

	@Transactional
	public void updateUser(Integer userId, UserDto userDto) {
		
		User existingUser = userRepository.getUserByUserId(userId)
			.orElseThrow(() -> new UserNotFoundException("No User found with id :" + userId));
		
		User updatedUser = UserUtil.toUser(existingUser, userDto);

		userRepository.save(updatedUser);
	}

}

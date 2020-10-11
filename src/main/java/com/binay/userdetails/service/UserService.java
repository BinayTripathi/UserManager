package com.binay.userdetails.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binay.userdetails.exception.UserNotFoundException;
import com.binay.userdetails.persistence.entity.User;
import com.binay.userdetails.persistence.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public User getUser(Integer user_id) {
		return userRepository.getUserByUserId(user_id)
				.orElseThrow(() -> new UserNotFoundException("No User found with id :" + user_id));
	}
	

	@Transactional
	public User updateUser(Integer userId, User user) {
		
		User existingUser = userRepository.getUserByUserId(userId)
			.orElseThrow(() -> new UserNotFoundException("No User found with id :" + userId));
		
		/*existingUser.setFirstn(user.getFirstn());
		existingUser.setLastName(user.getLastName());
		existingUser.setGender(user.getGender());
		existingUser.s*/
		return userRepository.save(user);
	}

}

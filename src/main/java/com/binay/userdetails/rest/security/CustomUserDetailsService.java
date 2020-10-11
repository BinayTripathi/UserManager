package com.binay.userdetails.rest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.binay.userdetails.exception.UserNotFoundException;
import com.binay.userdetails.persistence.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		UserDetails userDetails =  userRepository.getUserByUserName(userName)
				.orElseThrow(() -> new UserNotFoundException("No User found with id :" + userName));
		
		return userDetails;
	}

}

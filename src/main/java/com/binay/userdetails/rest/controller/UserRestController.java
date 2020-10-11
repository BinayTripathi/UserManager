package com.binay.userdetails.rest.controller;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.binay.userdetails.persistence.entity.Address;
import com.binay.userdetails.persistence.entity.Gender;
import com.binay.userdetails.persistence.entity.User;
import com.binay.userdetails.persistence.repository.AddressRepository;
import com.binay.userdetails.persistence.repository.UserRepository;
import com.binay.userdetails.service.UserService;

@RestController
@Validated
public class UserRestController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	ExecutorService executorService;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AddressRepository addressRepo;
	
	@Autowired
	PasswordEncoder passwordEncoder; 
	
	@GetMapping("userdetails/{userId}")
	public ResponseEntity<User> userdetails(@PathVariable @Pattern(regexp = "[\\s]*[0-9]*[1-9]+",message="Only numbers allowed") String userId) {
		
		User user = userService.getUser(Integer.parseInt(userId));		
		return ResponseEntity.ok(user);
	}
	
	
	
	
	@SuppressWarnings("rawtypes")
	@PutMapping("userdetails/{userId}")
	public ResponseEntity updateUser(@PathVariable @Pattern(regexp = "[\\s]*[0-9]*[1-9]+",message="Only numbers allowed") String userId,
			@RequestBody User user) {
		
		userService.updateUser(Integer.parseInt(userId), user);
		return ResponseEntity.notFound().build();
		
	}
	
	@PostMapping("userdetails")
	public User createUser() {
		
		Address add = Address.builder()
				.city("Melbourne")
				.postCode(3131)
				.state("Vic")
				.build();
		Address address = addressRepo.save(add);
		
		User user = new User();
		user.setFirstn("Binay");
		user.setUserName("Binay");
		user.setLastName("Tripathi");
		user.setAddress(address);
		user.setGender(Gender.male);
		user.setPassword(passwordEncoder.encode("binay"));
		user.setRoles(Arrays.asList("ROLE_USER", "ROLE_ADMIN"));
		return userRepository.save(user);
		
	}

}

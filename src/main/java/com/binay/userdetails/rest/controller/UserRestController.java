package com.binay.userdetails.rest.controller;

import java.util.concurrent.ExecutorService;

import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.binay.userdetails.rest.dto.UserDto;
import com.binay.userdetails.service.UserService;

@RestController("api")
@Validated
public class UserRestController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	ExecutorService executorService;
	
	
	@GetMapping("userdetails/{userId}")
	public ResponseEntity<UserDto> userdetails(@PathVariable @Pattern(regexp = "[\\s]*[0-9]*[1-9]+",message="Only numbers allowed") String userId) {
		
		UserDto userDto = userService.getUser(Integer.parseInt(userId));		
		return ResponseEntity.ok(userDto);
	}
	
	
	
	
	@SuppressWarnings("rawtypes")
	@PutMapping("userdetails/{userId}")
	public ResponseEntity updateUser(@PathVariable @Pattern(regexp = "[\\s]*[0-9]*[1-9]+",message="Only numbers allowed") String userId,
			@RequestBody UserDto user) {
		
		userService.updateUser(Integer.parseInt(userId), user);
		return ResponseEntity.noContent().build();
		
	}
	

}

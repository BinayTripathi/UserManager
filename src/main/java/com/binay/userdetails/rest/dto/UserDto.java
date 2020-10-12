package com.binay.userdetails.rest.dto;

import com.binay.userdetails.persistence.entity.Address;
import com.binay.userdetails.persistence.entity.Gender;
import com.binay.userdetails.persistence.entity.Title;
import com.binay.userdetails.persistence.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

	private String firstn;
	private String lastname;
	private Title title;
	private Gender gender;
	private Address address;
}

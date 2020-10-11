package com.binay.userdetails.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.binay.userdetails.persistence.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	public Optional<User> getUserByUserId(Integer userId);

	public Optional<User> getUserByUserName(String userName);

}

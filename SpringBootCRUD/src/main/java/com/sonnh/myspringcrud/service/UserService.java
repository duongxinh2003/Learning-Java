package com.sonnh.myspringcrud.service;

import java.util.List;
import java.util.Optional;

import com.sonnh.myspringcrud.entity.User;

public interface UserService {
	
	List<User> getAllUser(); 
	
	void saveUser(User user);
	
	void deleteUser(Long id);
	
	Optional<User> findUserById(Long id);
	
	List<User> findUserByName(String name);
}

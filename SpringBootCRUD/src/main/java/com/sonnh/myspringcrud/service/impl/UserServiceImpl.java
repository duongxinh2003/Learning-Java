package com.sonnh.myspringcrud.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sonnh.myspringcrud.entity.User;
import com.sonnh.myspringcrud.repository.UserRepository;
import com.sonnh.myspringcrud.service.UserService;

@Service //this class is a service and create a beans
public class UserServiceImpl implements UserService{
	
	@Autowired //Inject UserRepository to UserServiceImp
	private UserRepository userRepository;

	@Override
	public List<User> getAllUser() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public void saveUser(User user) {
		userRepository.save(user);

	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public Optional<User> findUserById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public List<User> findUserByName(String name) {
		return userRepository.findUserByName(name);
	}
}

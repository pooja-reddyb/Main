package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.exception.UserNotFoundException;



public interface UserService {
	public UserDto createUser(UserDto userDto) ;
	
	
	public User getUserById(int id) throws UserNotFoundException;
	
	public List<User> getUsers();
	
	public String healthCheck(int id);
	
}

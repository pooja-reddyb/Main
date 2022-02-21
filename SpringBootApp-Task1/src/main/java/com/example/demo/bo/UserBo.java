package com.example.demo.bo;

import java.util.List;

import com.example.demo.dto.UserDto;
import com.example.demo.exception.UserNotFoundException;

public interface UserBo {
	
	public UserDto saveUser(UserDto userDto);

	public List<UserDto> getAllUsers();
	
	public String healthCheck(int id);
	
	public UserDto  getUserById(int id) throws UserNotFoundException ;
}

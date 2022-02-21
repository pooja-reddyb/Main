package com.example.demo.eo;

import java.util.List;

import com.example.demo.dto.UserDto;
import com.example.demo.exception.UserNotFoundException;

public interface UserEo {
	public UserDto saveUser(UserDto userDto);

	public List<UserDto> getUsers();
	
	public String healthCheck(int id);
	
	public UserDto  getUserById(int id) throws UserNotFoundException ;
}

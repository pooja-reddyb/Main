package com.example.demo.bo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.UserDto;
import com.example.demo.eo.UserEo;
import com.example.demo.exception.UserNotFoundException;


@Component
public class UserBoImpl implements UserBo {
	
	@Autowired
	private UserEo userEo;
	
	Logger logger = LoggerFactory.getLogger(UserBoImpl.class);

	@Override
	public UserDto saveUser(UserDto userDto) {
		
		logger.info("save data in BO layer");
		return userEo.saveUser(userDto);
	}

	@Override
	public List<UserDto> getAllUsers() {
		
		logger.info("fetched details of employees in BO");
		return userEo.getUsers();
	}
	
	@Override
	public String healthCheck(int id) {
	logger.info("healthcheck in BO ");
	return userEo.healthCheck(id);
	}

	@Override
	public UserDto getUserById(int id)  throws UserNotFoundException {
		
		logger.info("fetched of given employee id in BO");
		return userEo.getUserById(id);
	}

}


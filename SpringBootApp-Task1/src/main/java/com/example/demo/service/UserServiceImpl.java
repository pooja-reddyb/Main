package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bo.UserBoImpl;
import com.example.demo.dao.UserRepository;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.mapper.UserMapper;


@Service
public class UserServiceImpl implements UserService{

	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserBoImpl userBo;
    
	@Autowired
	private UserMapper userMapper;
	
//	@Autowired
//	private EmployeeRepository employeeRepository;

	@Override
	public UserDto createUser(UserDto userDto) {
		
		logger.info(" saved data in service layer");
		return userBo.saveUser(userDto);
	}

	@Override
	public List<User> getUsers() throws UserNotFoundException{
		
		logger.info("fetched data of Employees in service layer");
		List<User> user = userMapper.fromDtoList(userBo.getAllUsers());
		if(user.isEmpty()) {
			throw new UserNotFoundException("employee not found");
		}
		else {
			return user;
		}
	}
	
	@Override
	public String healthCheck(int id) {
		logger.info("health check of Employees in service layer");
		return userBo.healthCheck(id);
	}

	@Override
	public User getUserById(int id) throws UserNotFoundException{
		
		logger.info("fetched data of given employee id in service layer");
		return userMapper.convertToEntity(userBo.getUserById(id));
	}
	
	

}

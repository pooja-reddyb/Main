package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import com.example.demo.util.UserConstants;

@RestController
@RequestMapping("/users")

public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserMapper userMapper;
	
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@PostMapping(value=UserConstants.POST)
	public ResponseEntity<User> saveEmployee(@RequestBody UserDto userDto) 
	{
		User user = userMapper.convertToEntity(userService.createUser(userDto)); 
    	logger.info("saved details in controller");	 
		return new ResponseEntity<User>(user,HttpStatus.CREATED);
	}
		
	@GetMapping(value=UserConstants.GET) 
	public ResponseEntity<List<User>> getAllEmployees() 
	{
		List<User> users = userService.getUsers();
		logger.info("fetched the details of employee in controller ");
		return new ResponseEntity<List<User>>(users , HttpStatus.OK);
	}
	
	@GetMapping(value=UserConstants.GETFORHEALTH)
	public ResponseEntity<String> healthCheck(@PathVariable int id){
		String str = userService.healthCheck(id);
		logger.info("HealthCheck Successful");
		return new ResponseEntity<String>(str, HttpStatus.CREATED);
	}
	
	
//	@GetMapping(value="/employee/{id}")
//	public ResponseEntity<Employee> getEmployeeById(@Valid @PathVariable int id) throws EmployeeNotFoundException
//	{   
//		logger.info("fetched the details of Employee with ID !");
//		return new ResponseEntity<Employee>(employeeservice.getEmployeeById(id),HttpStatus.OK);
//	}
	
	@GetMapping(value=UserConstants.GETBYID)
	public ResponseEntity<User> getUserById(@PathVariable int id) throws UserNotFoundException {
	User user= userService.getUserById(id);
	return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}

}

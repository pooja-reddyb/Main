package com.example.demo.eo;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.demo.dao.UserRepository;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.exception.UserNotFoundException;

@Component
public class UserEoImpl implements UserEo{
	
	@Autowired
	private UserRepository userRepository;
	
	Logger logger = LoggerFactory.getLogger(UserEoImpl.class);

	@Override
	public UserDto saveUser(UserDto userDto) {
		
		logger.info("saved details in EO Layer");
		return userRepository.save(userDto);
	}

	@Override
	public List<UserDto> getUsers() {
		
		logger.info("saved details in EO Layer");
		return userRepository.findAll();
	}

	@Override
	public String healthCheck(int id) {
		logger.info("Health check in EO");
		Optional<UserDto> s = userRepository.findById(id);
		if(s.isPresent()) {
			return ("HealthCheck-Success");
		}
		else {
			return ("HealthCheck-Failure");
		}
	}
	
	@Override
	public UserDto getUserById(int id) throws UserNotFoundException{
		logger.info("fetched data of given emp id in EO");
		Optional<UserDto> user =  userRepository.findById(id);
		UserDto s = null;
		if(user.isPresent()) {
			s = user.get();
				logger.info("retrieve all method in progress");
			return s;
		}
		else {
			//logger.info("No Records Found");
			throw new UserNotFoundException("No Records Found");

		}
    }
	
	

	

}

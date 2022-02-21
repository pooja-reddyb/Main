package com.example.demo.exception;

import org.springframework.stereotype.Component;

//@Component
public class UserNotFoundException extends RuntimeException{
	UserNotFoundException()
	{
	}
		public UserNotFoundException(String s)
		{
			super(s);
		}
	}

package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.demo.dto.UserDto;
import com.fasterxml.jackson.databind.ObjectMapper;


	
@SpringBootTest
@AutoConfigureMockMvc
class MainApplicationTests {

	@Autowired
	private MockMvc mockmvc;

	@Autowired
	private WebApplicationContext webcontext;

	ObjectMapper om = new ObjectMapper();



	@Before
	private void setUp()
	{
	mockmvc = MockMvcBuilders.webAppContextSetup(webcontext).build();
	}



	@Test
	public void createUserTest() throws Exception{
	UserDto userdto = new UserDto();
	userdto.setName("bhavana");
	userdto.setLocation("hyd");
	String jsonRequest = om.writeValueAsString(userdto);
	mockmvc.perform(post("/users/addUsers").content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isCreated());



	}




	@Test
	public void getUserByIdTest() throws Exception
	{
	mockmvc.perform( MockMvcRequestBuilders.get("/users/user/{id}",1).accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isCreated()).andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
	}


	@Test
	public void getAllUsersTest() throws Exception{
	UserDto dto = new UserDto();
	dto.setName("bhavana");
	dto.setLocation("hyd");
	String jsonRequest = om.writeValueAsString(dto);
	mockmvc.perform(get("/users/getAll").contentType(MediaType.APPLICATION_JSON_VALUE)).andDo(print());
	}
	}



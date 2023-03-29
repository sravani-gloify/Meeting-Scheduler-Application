package com.jcg.mapstruct.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jcg.mapstruct.dto.UserDto;
import com.jcg.mapstruct.model.User;
import com.jcg.mapstruct.service.UserService;
//mark as controoler
@RestController
//create the basic path for mapping
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
       //creating a put mapping that save the detail of a User 
	@PostMapping("/save")
	public HttpEntity<UserDto> createUser(@RequestBody UserDto userDto){
		userDto=service.save(userDto);
		return new ResponseEntity<>(userDto,HttpStatus.CREATED);
		
	}
	//creating a get mapping that retrieves the detail of a specific user
	@GetMapping("/{id}")
	public HttpEntity<UserDto> getUser(@PathVariable Long id){
		UserDto userDto=service.findOne(id);
		return new ResponseEntity<>(userDto,HttpStatus.CREATED);
		
	}
	//creating a get mapping that retrieves the detail of a specific user by emailid
	@GetMapping
	public User findByUserEmailId( String EmailId)
	{
		return service.findUserByEmailId(EmailId);
		}


}

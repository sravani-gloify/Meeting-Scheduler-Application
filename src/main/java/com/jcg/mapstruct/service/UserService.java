package com.jcg.mapstruct.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jcg.mapstruct.Exeception.ResourceNotFoundException;
import com.jcg.mapstruct.dto.UserDto;
import com.jcg.mapstruct.mapper.UserMapper;
import com.jcg.mapstruct.model.User;
import com.jcg.mapstruct.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	@Autowired 
	private UserMapper userMapper;
	
	 public UserDto save(UserDto userDto) {
	   User user  = userMapper.dtoToModel(userDto);
	   User userEntity= repository.save(user);
	   userDto=userMapper.modelToDto(userEntity);
	   return userDto;
	       
	    }

	    public List<User> findAll() {
	     
	        return repository.findAll();
	    }

	    public UserDto findOne(Long id) {
	       
	       User user=repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Resource NotFound",HttpStatus.NOT_FOUND));
	       UserDto userDto=userMapper.modelToDto(user);
	        return userDto;
	    }

		public User findUserByEmailId(String emailId) {
			return repository.findByEmailId(emailId);
		}  
      public List<UserDto> getUsers(){
    	  List<User> user=repository.findAll();
    	  List<UserDto> userDtos=userMapper.modelToDto(user);
		return userDtos;
	   
      }
		public UserRepository getRepository() {
			return repository;
		}

		public void setRepository(UserRepository repository) {
			this.repository = repository;
		}

		public UserMapper getUserMapper() {
			return userMapper;
		}

		public void setUserMapper(UserMapper userMapper) {
			this.userMapper = userMapper;
		}

}

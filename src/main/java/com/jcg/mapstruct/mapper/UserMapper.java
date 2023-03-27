package com.jcg.mapstruct.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.jcg.mapstruct.dto.UserDto;
import com.jcg.mapstruct.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
	
	UserMapper INSTANCE=Mappers.getMapper(UserMapper.class);
	
	UserDto modelToDto(User user);
	@InheritInverseConfiguration
	User dtoToModel(UserDto userDto);
	List<UserDto> modelToDto(List<User> findAll);

}

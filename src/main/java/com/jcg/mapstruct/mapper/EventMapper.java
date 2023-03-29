package com.jcg.mapstruct.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.jcg.mapstruct.dto.EventDto;
import com.jcg.mapstruct.model.Event;

//mark as mapper
@Mapper(componentModel = "spring")
public interface EventMapper {
    
	EventMapper INSTANCE =Mappers.getMapper(EventMapper.class);
	
	
	EventDto toEventDto(Event event);
	@InheritInverseConfiguration
	Event toEvent(EventDto eventDto);

	
	
	
}

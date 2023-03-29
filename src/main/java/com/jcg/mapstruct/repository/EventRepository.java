package com.jcg.mapstruct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jcg.mapstruct.dto.EventDto;
import com.jcg.mapstruct.model.Event;
//repository that extends CrudRepository  
@Repository
public interface EventRepository  extends JpaRepository<Event, Long>{

	EventDto save(EventDto eventDto);

}

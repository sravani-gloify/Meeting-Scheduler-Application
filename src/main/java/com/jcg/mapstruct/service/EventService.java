package com.jcg.mapstruct.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jcg.mapstruct.Exeception.ResourceNotFoundException;
import com.jcg.mapstruct.dto.EventDto;
import com.jcg.mapstruct.mapper.EventMapper;
import com.jcg.mapstruct.model.Event;
import com.jcg.mapstruct.repository.EventRepository;

@Service
public class EventService {
  
	@Autowired
	private EventRepository  eventRepository;
	
        @Autowired
	private EventMapper eventMapper;
	
	//saving a specific record by using the method save() of CrudRepository  
	public EventDto createEvent(EventDto eventDto) {
	Event event=eventMapper.toEvent(eventDto);
		event=eventRepository.save(event);
	eventDto=eventMapper.toEventDto(event);
		return eventDto;
	}	
	
//saving a specific record by using the method createEvent() of CrudRepository  firstly check the already data is available or not
	  public boolean isTimeSlotAvailable(Event newEvent) {
	        List<Event> existingMeetings = eventRepository.findAll();
	        for (Event meeting : existingMeetings) {
	            if (meeting.getStartTime().isBefore(newEvent.getEndTime()) && meeting.getEndTime().isAfter(newEvent.getStartTime())) {
	                return false;
	            }
	        }
	        return true;
	    }
	    public void addEvent(Event event) {
	        eventRepository.save(event);
	    }
          
	//getting a specific record by using the method getMeetingForDay() of CrudRepository  
	    public List<Event> getMeetingsForDay(LocalDate date) {
	        List<Event> meetings = new ArrayList<>();
	        List<Event> allMeetings = eventRepository.findAll();
	        for (Event events : allMeetings) {
	            if (events.getStartTime().toLocalDate().equals(date)) {
	                meetings.add(events);
	            }
	        }
	        return meetings;
	    }	
	
	//getting a specific record by using the method getEvent() of CrudRepository  
	public Event getEvent(Long eventId)
	{
		
		Event event=eventRepository.findById(eventId).orElseThrow(()->new ResourceNotFoundException("event not found", HttpStatus.NOT_FOUND));
	    return event;
		
	}
	//getting all record by using the method findAll() of CrudRepository  
	public List<Event> findAll(){
		
		return eventRepository.findAll();
		
		
	}
      // creating the getter and setter for the autowired classes
	public EventRepository getEventRepository() {
		return eventRepository;
	}


	public void setEventRepository(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}


	public EventMapper getEventMapper() {
		return eventMapper;
	}


	public void setEventMapper(EventMapper eventMapper) {
		this.eventMapper = eventMapper;
	}

 
	

	
}

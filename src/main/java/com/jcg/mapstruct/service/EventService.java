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
	
	public EventDto createEvent(EventDto eventDto) {
	Event event=eventMapper.toEvent(eventDto);
		event=eventRepository.save(event);
	eventDto=eventMapper.toEventDto(event);
		return eventDto;
	}	

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
	public Event getEvent(Long eventId)
	{
		
		Event event=eventRepository.findById(eventId).orElseThrow(()->new ResourceNotFoundException("event not found", HttpStatus.NOT_FOUND));
	    return event;
		
	}
	
	public List<Event> findAll(){
		
		return eventRepository.findAll();
		
		
	}
      
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

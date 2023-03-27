package com.jcg.mapstruct.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jcg.mapstruct.Util.ResponseUtil;
//import com.jcg.mapstruct.dto.EventDto;
import com.jcg.mapstruct.dto.ResponseDto;
import com.jcg.mapstruct.model.Event;
import com.jcg.mapstruct.service.EventService;

@RestController
@RequestMapping("/event")
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	
//	@PostMapping("/save")
//	public HttpEntity<ResponseDto> createEvent(@RequestBody EventDto eventDto)
//	{
//		eventDto=eventService.createEvent(eventDto);
//		
//		return  new ResponseEntity<>(ResponseUtil.getSuccessResponse(eventDto),HttpStatus.CREATED) ;
//		
//	}
//	
	
	
	@PostMapping("/save")
    public ResponseEntity<String> addMeeting(@RequestBody Event event) {
        if (eventService.isTimeSlotAvailable(event)) {
            eventService.addEvent(event);
            return ResponseEntity.ok("Event added successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Time slot is already occupied.");
        }
    }

    @GetMapping("/{date}")
    public List<Event> getMeetingsForDay(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return eventService.getMeetingsForDay(date);
    }
    
	
	@GetMapping("/{id}")
	public HttpEntity<ResponseDto> getEvent(@PathVariable Long id)
	{
		Event event=eventService.getEvent(id);
		
		return  new ResponseEntity<>(ResponseUtil.getSuccessResponse(event),HttpStatus.CREATED) ;
		
	}
		
	@GetMapping("/find")
	public HttpEntity<ResponseDto> getAll(){
		
		List<Event> eventDtos=eventService.findAll();
		
		return new ResponseEntity<>(ResponseUtil.getSuccessResponse(eventDtos),HttpStatus.OK);
			}

	public EventService getEventService() {
		return eventService;
	}

	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}
	

}

package com.jcg.mapstruct.controller;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.jcg.mapstruct.dto.MeetingDto;
import com.jcg.mapstruct.service.MeetingService;


@RequestMapping("/meeting")
@RestController
public class MeetingController {
	
	@Autowired
	private MeetingService  meetingService;
	
	 Logger log= LoggerFactory.getLogger(MeetingController.class);

	@PostMapping("/save")
	public HttpEntity<MeetingDto> scheduleMeeting(@RequestBody  MeetingDto meetingDto) throws IOException, MessagingException
	{
		meetingDto=meetingService.scheduleMeeting(meetingDto);
		log.info("save meeting");
		return new ResponseEntity<>(meetingDto,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/schedulerEmail")
	public HttpEntity<List<MeetingDto>> getMeeting(@RequestParam String schedulerEmail)
	{
		List<MeetingDto> meetingDto=meetingService.getMeeting(schedulerEmail);
		
		return new ResponseEntity<>(meetingDto,HttpStatus.OK);
		
	}
	@GetMapping(value="/event/{Id}")
	public HttpEntity<MeetingDto> getAvailabilityByEventId(@PathVariable Long Id)
	{
		
		return meetingService.getAvailabilityByEventId(Id) ;
		
	}
	
//	@GetMapping("/{id}")
//	public Meeting getMeetingById(@PathVariable Long id)
//	{
//		return meetingService.findByMeetingId(id);
//		
//	}
	@GetMapping("/v")
	public String getmeeting() {
		
		return "meeting scheduled";
	}
    
	
	public MeetingService getMeetingService() {
		return meetingService;
	}

	public void setMeetingService(MeetingService meetingService) {
		this.meetingService = meetingService;
	}
	
}

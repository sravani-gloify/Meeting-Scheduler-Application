package com.jcg.mapstruct.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.jcg.mapstruct.dto.MeetingDto;
import com.jcg.mapstruct.model.Candidate;
import com.jcg.mapstruct.model.Event;
import com.jcg.mapstruct.model.Meeting;
import com.jcg.mapstruct.model.User;
import com.jcg.mapstruct.service.CandidateService;
import com.jcg.mapstruct.service.EventService;
import com.jcg.mapstruct.service.UserService;

//mark as mapper
@Mapper(componentModel = "spring")
public class MeetingMapper {
	@Autowired 
	private CandidateService service;
	@Autowired
       private UserService userService;
	@Autowired
	private EventService eventService;
 
	//mapping meeting to meeting dto 
	public MeetingDto toMeetingDto(Meeting meeting)
	{
		return MeetingDto.builder()
				.id(meeting.getId())
				.candidateEmailId(Optional.ofNullable(meeting.getCandidate()).map(Candidate::getEmail).orElse(null))
		  	    //.interviewerEmailId(Optional.ofNullable(meeting.getInterviewer()).map(User::getEmailId).orElse(null))
				.eventId(Optional.ofNullable(meeting.getEvent()).map(Event::getId).orElse(null))
				.meetingStatus(meeting.getMeetingStatus())
				.schedulerEmailId(Optional.ofNullable(meeting.getScheduler()).map(User::getEmailId).orElse(null))
				.meetingLink(meeting.getMeetingLink())
				.dateTime(meeting.getDateTime())
				.build();
	}
	
	//mapping meetingdto to meeting
	
	public Meeting toMeeting(MeetingDto meetingDto)
	{
		Meeting meeting= new Meeting();
		meeting.setCandidate(service.findCadidateByEmail(meetingDto.getCandidateEmailId()));
		meeting.setScheduler(userService.findUserByEmailId(meetingDto.getSchedulerEmailId()));
		meeting.setEvent(eventService.getEvent(meetingDto.getEventId()));
		//meeting.setInterviewer(userService.findUserByEmailId(meetingDto.getInterviewerEmailId()));
		meeting.setDateTime(meetingDto.getDateTime());
		meeting.setMeetingLink(meetingDto.getMeetingLink());
		meeting.setMeetingStatus(meetingDto.getMeetingStatus());
		return meeting;
		
	}
	
	
	public  List<MeetingDto> toDtos(List<Meeting> meetings){
		if(meetings == null)
		{
			return new ArrayList<>();
		}
		return meetings
				.stream()
				.map(meeting -> toMeetingDto(meeting))
				.collect(Collectors.toList());
	}	
	
	public CandidateService getService() {
		return service;
	}
	public void setService(CandidateService service) {
		this.service = service;
	}
	
	public EventService getEventService() {
		return eventService;
	}
	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}
	
}

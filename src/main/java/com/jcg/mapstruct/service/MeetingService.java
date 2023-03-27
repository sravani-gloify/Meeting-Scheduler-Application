package com.jcg.mapstruct.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

import com.jcg.mapstruct.dto.CalendarDto;
import com.jcg.mapstruct.dto.EmailDto;
import com.jcg.mapstruct.dto.MeetingDto;
import com.jcg.mapstruct.mapper.MeetingMapper;
import com.jcg.mapstruct.model.Candidate;
import com.jcg.mapstruct.model.Meeting;
import com.jcg.mapstruct.model.User;
import com.jcg.mapstruct.repository.EventRepository;
import com.jcg.mapstruct.repository.MeetingRepository;

import biweekly.parameter.ParticipationLevel;
import biweekly.property.Attendee;
import biweekly.property.Organizer;

@Service
public class MeetingService {
	
	@Autowired
	private MeetingRepository meetingRepository;
	
	@Autowired
	private MeetingMapper meetingMapper;
	
	@Autowired
	private EmailService emailService;
	
	public MeetingDto scheduleMeeting(MeetingDto  meetingDto) throws IOException, MessagingException
	{
		Meeting meeting=meetingMapper.toMeeting(meetingDto);
		meetingRepository.save(meeting);
		EmailDto emailDto=composeEmail(meeting);
		CalendarDto calendarDto=composeCalendar(meeting);
		System.out.println(calendarDto.getDescription());
		System.out.println(emailDto.getMessage());
		emailService.sendEmail(emailDto);
		emailService.sendCalendarInvite(calendarDto);
		meetingDto=meetingMapper.toMeetingDto(meeting);
		return meetingDto;
	 			
	}
   public HttpEntity<MeetingDto> getAvailabilityByEventId(Long eventId) {
		
	 //  System.out.println(meetingRepository.findById(eventId));
	   
		return meetingRepository.getAvailabilityByEventId(eventId);
	}
	private CalendarDto composeCalendar(Meeting meeting)
	{
		Candidate candidate=meeting.getCandidate();
		return CalendarDto.builder()
				.subject(String.format("You having been invited to this meeting by Scheduler",candidate.getName()))
				.description("You having been invited to this amazing event! Let's program Gloify!")
				.summary("Programming gloify schedhule")
				.organizer(new Organizer( "Scheduler","akula.sravani@gloify.com"))
				.meetingLink(meeting.getMeetingLink())
				.eventDateTime(meeting.getDateTime())
				.attendees(getAttendees(meeting))
		        .build();
	}
	private List<Attendee> getAttendees(Meeting meeting) {
		Candidate candidate=meeting.getCandidate();
		User user=meeting.getScheduler();
		List<Attendee> attendees=new ArrayList<>();
		
		Attendee candidateAttendee =new Attendee(candidate.getName(),candidate.getEmail());
		candidateAttendee.setParticipationLevel(ParticipationLevel.REQUIRED);
		attendees.add(candidateAttendee);
		
		
		Attendee schduelrAttendee=new  Attendee(user.getName(), user.getEmailId());
		schduelrAttendee.setParticipationLevel(ParticipationLevel.REQUIRED);
		attendees.add(schduelrAttendee);
		
		return attendees;
	}
	public List<MeetingDto> getMeeting(String schedulerEmail)
	{
		List<Meeting> meetings=meetingRepository.getMeetingByScheduler_EmailId(schedulerEmail);
		List<MeetingDto> meetingDtos=meetingMapper.toDtos(meetings);
		return meetingDtos;
	} 
	public Meeting findByMeetingId(Long id) {
		
		return meetingRepository.getById(id);
		
	}
	
	public EmailDto composeEmail(Meeting meeting) {
		return EmailDto.builder()
				.from(meeting.getScheduler().getEmailId())
				.message(String.format("please check the my  availabilty and schedule it   "+ meeting.getMeetingLink(), meeting.getDateTime()))
				.subject(" schedule the meeting")
				.toList(getToEmails(meeting))
				.build();
	       }
	 List<String> getToEmails(Meeting meeting) {
		List<String> emails=new ArrayList<>();
		emails.add(meeting.getCandidate().getEmail());
		emails.add(meeting.getScheduler().getEmailId());
     	//emails.add(meeting.getInterviewer().getEmailId());
		return emails;
	}
	 
	 
	public MeetingRepository getMeetingRepository() {
		return meetingRepository;
	}

	public void setMeetingRepository(MeetingRepository meetingRepository) {
		this.meetingRepository = meetingRepository;
	}
	public MeetingMapper getMeetingMapper() {
		return meetingMapper;
	}
	public void setMeetingMapper(MeetingMapper meetingMapper) {
		this.meetingMapper = meetingMapper;
	}
	public EmailService getEmailService() {
		return emailService;
	}
	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}
	
	
	
  
}

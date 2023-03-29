package com.jcg.mapstruct.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
//mark as entity
@Entity
//defining table name
@Table(name="meeting")
//create default constructor
@NoArgsConstructor
//create parameter constructor
@AllArgsConstructor
@Builder
public class Meeting {
	//id is an primary key
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long id;
	
//manytoone relationship for the candidate and metting
    @ManyToOne(optional = true)
    @JoinColumn(name = "candidate_id", referencedColumnName = "id")
    private Candidate candidate;
////manytoone relationship for the candidate and metting	
    @ManyToOne(optional = false)
    @JoinColumn(name = "scheduler_id", referencedColumnName = "id")
    private User scheduler;
//    
//    @ManyToOne(optional = false)
//    @JoinColumn(name = "interviwer_id", referencedColumnName = "id")
//    private User interviewer;
    @Column
    private LocalDateTime dateTime;
    @ManyToOne(optional = false)
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private Event event;
    @Enumerated(EnumType.STRING)
    @Column
    private MeetingStatus meetingStatus;
    @Column
    private String meetingLink;
    
    private String attendees;
   
	  	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Candidate getCandidate() {
		return candidate;
	}
	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
	public User getScheduler() {
		return scheduler;
	}
	public void setScheduler(User scheduler) {
		this.scheduler = scheduler;
	}
//	public User getInterviewer() {
//		return interviewer;
//	}
//	public void setInterviewer(User interviewer) {
//		this.interviewer = interviewer;
//	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public MeetingStatus getMeetingStatus() {
		return meetingStatus;
	}
	public void setMeetingStatus(MeetingStatus meetingStatus) {
		this.meetingStatus = meetingStatus;
	}
	public String getMeetingLink() {
		return meetingLink;
	}
	public void setMeetingLink(String meetingLink) {
		this.meetingLink = meetingLink;
	}
	public String getAttendees() {
		return attendees;
	}
	public void setAttendees(String attendees) {
		this.attendees = attendees;
	}
	
	}

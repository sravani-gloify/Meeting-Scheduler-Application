package com.jcg.mapstruct.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="feedback")
public class FeedBack {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	@OneToOne
	@JoinColumn(name = "candidate_id", referencedColumnName = "id")
	private Candidate candidate;
	@OneToOne
	@JoinColumn(name = "meeting_id", referencedColumnName = "id")
	private Meeting meeting;
	@Column
	@Enumerated(EnumType.STRING)
	private MeetingStatus meetingStatus;
	@Column
	private String remaks;
	@Column
	private Integer rating;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Candidate getCandidate() {
		return candidate;
	}
	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
	public Meeting getMeeting() {
		return meeting;
	}
	public void setMeeting(Meeting meeting) {
		this.meeting = meeting;
	}
	public MeetingStatus getMeetingStatus() {
		return meetingStatus;
	}
	public void setMeetingStatus(MeetingStatus meetingStatus) {
		this.meetingStatus = meetingStatus;
	}
	public String getRemaks() {
		return remaks;
	}
	public void setRemaks(String remaks) {
		this.remaks = remaks;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	

}

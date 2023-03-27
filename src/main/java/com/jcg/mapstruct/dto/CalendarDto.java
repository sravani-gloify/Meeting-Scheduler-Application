package com.jcg.mapstruct.dto;

import java.time.LocalDateTime;
import java.util.List;

import biweekly.property.Attendee;
import biweekly.property.Organizer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder(toBuilder = true)
public class CalendarDto {
	private String subject;
	private String description;
	private String summary;
	private Organizer organizer;
	private String meetingLink;
	private LocalDateTime eventDateTime;
	private List<Attendee> attendees;
}

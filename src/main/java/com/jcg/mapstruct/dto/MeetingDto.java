package com.jcg.mapstruct.dto;
import java.time.LocalDateTime;

import com.jcg.mapstruct.model.MeetingStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
 @Builder(toBuilder = true)
 @AllArgsConstructor
 @NoArgsConstructor
 @ToString
 @Data
public class MeetingDto {
	
	private Long id;
    
    private String candidateEmailId;
    
    private String schedulerEmailId;
    
    private String interviewerEmailId;
    
    private LocalDateTime dateTime;
    
    private Long eventId;
   
    private MeetingStatus meetingStatus;
   
    private String meetingLink;
    
   

	    
    
   
	
}

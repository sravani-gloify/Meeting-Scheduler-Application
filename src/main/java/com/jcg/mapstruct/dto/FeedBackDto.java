package com.jcg.mapstruct.dto;


import com.jcg.mapstruct.model.MeetingStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FeedBackDto {
    
private Long id;
	private String candidateEmailId;
	private String meetingName;
	private MeetingStatus meetingStatus;
	private String remaks;
	private Integer rating;
}

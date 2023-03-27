package com.jcg.mapstruct.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventDto {
	
    private Long id;
    private String name;
    private String duration;
    private LocalDate scheduleDate;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
    
	
	
}

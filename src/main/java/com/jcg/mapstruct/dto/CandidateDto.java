package com.jcg.mapstruct.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CandidateDto {
	 
	    private Long id;
	    
	    private String name;
	    
	    private String email;
	    
	    private String address;
	   
	    private Long mobileNo;
	

}





package com.jcg.mapstruct.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.jcg.mapstruct.dto.CandidateDto;
import com.jcg.mapstruct.model.Candidate;

@Mapper(componentModel = "spring")
public interface CandidateMapper {
	
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	CandidateDto toCandidateDto(Candidate  candidate);

	@InheritInverseConfiguration
	Candidate toCandidate(CandidateDto candidateDto);
    
}

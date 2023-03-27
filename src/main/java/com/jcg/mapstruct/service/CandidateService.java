package com.jcg.mapstruct.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jcg.mapstruct.Exeception.ResourceNotFoundException;
import com.jcg.mapstruct.dto.CandidateDto;
import com.jcg.mapstruct.mapper.CandidateMapper;
import com.jcg.mapstruct.model.Candidate;
import com.jcg.mapstruct.repository.CandidateRepository;

@Service
public class CandidateService {

	@Autowired
	private CandidateRepository candidateRepository;
	@Autowired
	private CandidateMapper  candidateMapper;
	
	public CandidateDto createCandidate(CandidateDto candidateDto) {
		
		Candidate candidate=candidateMapper.toCandidate(candidateDto);
		 candidate=candidateRepository.save(candidate);
		 candidateDto=candidateMapper.toCandidateDto(candidate);
		return candidateDto;
	   }
	   public CandidateDto findOne(Long id) {
	       Optional<Candidate> optionalUser=candidateRepository.findById(id);
	       Candidate user=optionalUser.orElseThrow(()->new ResourceNotFoundException("ResourceNotFound",HttpStatus.NOT_FOUND));
	       CandidateDto userDto=candidateMapper.toCandidateDto(user);
	        return userDto;
	    }
	
		public List<Candidate> findAll() {
			
			return candidateRepository.findAll();
		}
		
		public Candidate findCadidateByEmail(String email) {
		
			return candidateRepository.findByEmail(email);
		}
		public CandidateRepository getCandidateRepository() {
			return candidateRepository;
		}
		public void setCandidateRepository(CandidateRepository candidateRepository) {
			this.candidateRepository = candidateRepository;
		}

		public CandidateMapper getCandidateMapper() {
			return candidateMapper;
		}

		public void setCandidateMapper(CandidateMapper candidateMapper) {
			this.candidateMapper = candidateMapper;
		}


    
}

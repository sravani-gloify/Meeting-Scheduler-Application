package com.jcg.mapstruct.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jcg.mapstruct.dto.CandidateDto;
import com.jcg.mapstruct.model.Candidate;
import com.jcg.mapstruct.service.CandidateService;


@RequestMapping("/candidate")
@RestController
public class CandidateController {
	
	@Autowired
	private CandidateService candidateService;
	
	@PostMapping("/save")
	public HttpEntity<CandidateDto> CreateCandidate(@RequestBody CandidateDto candidateDto)
	{
		CandidateDto candidate=candidateService.createCandidate(candidateDto);
		return new ResponseEntity<>(candidate,HttpStatus.CREATED);
		
	}	
	@GetMapping("/{id}")
	public HttpEntity<CandidateDto> getCandidate(@PathVariable Long id)
	{
		CandidateDto candidate=candidateService.findOne(id);
		return new ResponseEntity<>(candidate,HttpStatus.CREATED);
		
	}	
	  @GetMapping
	  public Candidate findByEmail(String Email)
	  {
		return candidateService.findCadidateByEmail(Email);
		  
	  }  
	
	@GetMapping("/getAll")
	public List<Candidate> getCandidate()
	{
		return candidateService.findAll() ;
		
	}
	
	public CandidateService getCandidateService() {
		return candidateService;
	}
	public void setCandidateServiceImpl(CandidateService candidateService) {
		this.candidateService = candidateService;
	}
	
}

package com.jcg.mapstruct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jcg.mapstruct.model.Candidate;


@Repository
public interface CandidateRepository extends JpaRepository<Candidate,Long>{

	Candidate findByEmail(String email);
	

}

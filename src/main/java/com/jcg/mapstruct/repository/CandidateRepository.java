package com.jcg.mapstruct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jcg.mapstruct.model.Candidate;

//repository that extends CrudRepository  
@Repository
public interface CandidateRepository extends JpaRepository<Candidate,Long>{

	Candidate findByEmail(String email);
	

}

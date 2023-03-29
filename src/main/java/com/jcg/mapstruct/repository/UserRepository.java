package com.jcg.mapstruct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jcg.mapstruct.model.User;
//repository that extends CrudRepository  
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmailId(String emailId);

	

}

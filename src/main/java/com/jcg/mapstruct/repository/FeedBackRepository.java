package com.jcg.mapstruct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jcg.mapstruct.model.FeedBack;
@Repository
public interface FeedBackRepository extends JpaRepository<FeedBack,Long>{

}

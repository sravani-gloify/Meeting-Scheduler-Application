package com.jcg.mapstruct.repository;

import com.jcg.mapstruct.model.Commerce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommerceRepository extends JpaRepository<Commerce, Integer> {
}

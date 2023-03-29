package com.jcg.mapstruct.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Repository;

import com.jcg.mapstruct.dto.MeetingDto;
import com.jcg.mapstruct.model.Meeting;

//repository that extends CrudRepository  
@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Long>{

	List<Meeting> getMeetingByScheduler_EmailId(String schedulerEmail);

//	@Query(value= "select event_id,scheduler_id,event.name,event.duration,event.start_time,event.end_time from meeting RIGHT JOIN event  ON meeting.event_id=event.id;",nativeQuery = true)
	HttpEntity<MeetingDto> getAvailabilityByEventId(Long EventId);
 
	

	
}

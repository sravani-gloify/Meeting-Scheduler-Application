package com.jcg.mapstruct.model;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
//create parameter constructor
@AllArgsConstructor
//getter and seeters
@Data
//mark as entity
@Entity
//defining table name
@Table(name="event")
public class Event {   
	//id is an primary key
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String name;
    @Column
	private String duration;
    private LocalDate scheduleDate;
	@Column
	private LocalDateTime startTime;
    @Column
	private  LocalDateTime endTime;
	
}

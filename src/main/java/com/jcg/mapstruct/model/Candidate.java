package com.jcg.mapstruct.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//mark as an entity
@Entity
//defining the table name
@Table(name="candidates")
public class Candidate {
//Defining  id as primary key  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String name;
    @Column(name = "email",unique = true)
	private String email;
    @Column
    private String address;
    @Column
    private Long mobileNo;
   
	public Candidate(Long id, String name, String email, String address, Long mobileNo) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.mobileNo = mobileNo;
	}
	
	public Candidate() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email= email;
	}
	       
}


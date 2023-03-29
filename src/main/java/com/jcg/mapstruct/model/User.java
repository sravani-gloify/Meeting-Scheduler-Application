package com.jcg.mapstruct.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
//mark as entity
@Entity
//defining the table name
@Table(name="users")
//create no fileds constructor
@NoArgsConstructor
//create parameter constructor
@AllArgsConstructor
//mark as to string
@ToString
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String name;
	@Column(name = "emailId",unique = true,nullable = false)
	private String emailId;
	@Column
	private  Role role=Role.Admin;
	@Column
	private Long mobileNo;
	@JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
	@Column
	private String password;
	@Column
	private String forgotToken;
	@Column
	private Integer otp;
	
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
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getForgotToken() {
		return forgotToken;
	}
	public void setForgotToken(String forgotToken) {
		this.forgotToken = forgotToken;
	}
	public Integer getOtp() {
		return otp;
	}
	public void setOtp(Integer otp) {
		this.otp = otp;
	}
	

   
}

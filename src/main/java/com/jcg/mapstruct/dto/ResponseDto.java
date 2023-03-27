package com.jcg.mapstruct.dto;

import java.util.Collection;

public class ResponseDto<T> {
	private String message;
	private  String StatusCode ;
	private  Collection<T> data;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatusCode() {
		return StatusCode;
	}
	public void setStatusCode(String statusCode) {
		StatusCode = statusCode;
	}
	public Collection<T> getData() {
		return data;
	}
	public void setData(Collection<T> data) {
		this.data = data;
	}
	
	
  
}

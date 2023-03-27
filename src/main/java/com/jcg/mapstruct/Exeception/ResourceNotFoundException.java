package com.jcg.mapstruct.Exeception;

import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
public class ResourceNotFoundException extends RuntimeException {
	
		private String messge;
		private HttpStatus code;
		
		public String getMessge() {
			return messge;
		}
		public void setMessge(String messge) {
			this.messge = messge;
		}
		public HttpStatus getCode() {
			return code;
		}
		public void setCode(HttpStatus code) {
			this.code = code;
		}
		public ResourceNotFoundException(String messge, HttpStatus code) {
			super();
			this.messge = messge;
			this.code = code;
		}
		
	
		

}

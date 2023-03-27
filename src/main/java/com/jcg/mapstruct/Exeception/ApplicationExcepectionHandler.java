package com.jcg.mapstruct.Exeception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.jcg.mapstruct.Util.ResponseUtil;
import com.jcg.mapstruct.dto.ResponseDto;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class ApplicationExcepectionHandler {
	
	@SuppressWarnings("rawtypes")
	@ExceptionHandler(value =ResourceNotFoundException.class)
   public ResponseEntity<ResponseDto> notFoundexception(ResourceNotFoundException  notfoundException){
	log.info(" Resource Not Found ");
	return new ResponseEntity<>(ResponseUtil.getFailureResponse(notfoundException.getMessage()),notfoundException.getCode());
		
	}
}

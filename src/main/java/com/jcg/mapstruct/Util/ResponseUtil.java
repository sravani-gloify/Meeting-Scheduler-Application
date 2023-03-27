package com.jcg.mapstruct.Util;

import java.util.Collection;
import java.util.Collections;

import com.jcg.mapstruct.dto.ResponseDto;
import com.jcg.mapstruct.model.ApiStatus;


public class ResponseUtil {
	
	public static ResponseDto getSuccessResponse(Object data)
	{		
		ResponseDto responseDto=new ResponseDto();
		responseDto.setMessage("data fetched succefully");
		responseDto.setData(Collections.singleton(data));
		responseDto.setStatusCode(ApiStatus.Success.getValue());
		return responseDto;
		
	}
   public static ResponseDto getFailureResponse(String message)
	{
		ResponseDto response=new ResponseDto();
		response.setMessage(message);
		response.setStatusCode(ApiStatus.Failure.getValue());
		
		return response;
		
	}
	public static   ResponseDto getResponse(String message ,String status,Collection data)
	{
		
		ResponseDto response=new ResponseDto();
		response.setMessage(message);
		response.setStatusCode(status);
		response.setData(data);
		return response;
		
	}
	public static ResponseDto getResponse(String message ,String status,Object  data)
	{
		
		ResponseDto response=new ResponseDto();
		response.setMessage(message);
		response.setStatusCode(status);
		response.setData(Collections.singleton(data));

		return response;
		
	}

}

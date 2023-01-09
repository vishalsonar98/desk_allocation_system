package com.deskAllocationSystem.deskAllocation.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.deskAllocationSystem.deskAllocation.vo.ResponseVo;

import feign.FeignException.NotFound;

@RestControllerAdvice
public class DeskAllocationExceptionHandling {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(NotFound.class)
	public ResponseVo dataNotFoundException(NotFound exception){
		log.error(exception.getMessage());
		
		return new ResponseVo(500,"Information not found enter valid user/desk id..","");
	}
}

package com.deskAllocationSystem.desk.advice;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import javax.validation.ConstraintViolationException;
import javax.validation.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.deskAllocationSystem.desk.vo.ResponseVo;

import feign.FeignException.NotFound;

@RestControllerAdvice
public class DeskExceptionHandling {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseVo dataNotFoundException(ConstraintViolationException exception){
		log.error(exception.getMessage());
		Map<Path, String> errors = new HashMap<>();
		exception.getConstraintViolations().forEach(e->{
			errors.put(e.getPropertyPath(), e.getMessage());
		});
		return new ResponseVo(500,"Validation error",errors);
	}
	
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(NotFound.class)
	public ResponseVo dataNotFoundException(NotFound exception){
		log.error(exception.getMessage());
		
		return new ResponseVo(500,"Floor not found enter valid floor id..","");
	}
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseVo dataNotFoundException(NoSuchElementException exception){
		log.error(exception.getMessage());
		
		return new ResponseVo(404,"Desk not found enter valid desk id..","");
	}
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseVo dataNotFoundException(EmptyResultDataAccessException exception){
		log.error(exception.getMessage());
		
		return new ResponseVo(404,"Desk not found enter valid desk id..","");
	}
	
	
	
}

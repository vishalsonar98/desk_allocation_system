package com.DeskAllocationSystem.floor.advice;

import java.util.NoSuchElementException;

import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.DeskAllocationSystem.floor.exception.DataNotFoundException;
import com.DeskAllocationSystem.floor.vo.ResponseVo;

@RestControllerAdvice
public class FloorExceptionHandling {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(DataNotFoundException.class)
	public ResponseVo dataNotFoundException(DataNotFoundException exception){
		log.error(exception.getMessage());
		return new ResponseVo(404,exception.getMessage(),"");
	}
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseVo dataNotFoundException(NoSuchElementException exception){
		log.error("floor not found");
		return new ResponseVo(404,"floor not found","");
	}
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseVo incorrectDataException(ConstraintViolationException exception){
		log.error("Enter valid information");
		return new ResponseVo(500,"Enter valid information","");
	}
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseVo floorNotFoundException(EmptyResultDataAccessException exception){
		log.error("Enter valid floor id");
		return new ResponseVo(500,"Enter valid floor id","");
	}
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseVo floorNotFoundException(MethodArgumentTypeMismatchException exception){
		log.error("Enter valid floor id");
		return new ResponseVo(500,"Enter valid floor id","");
	}
}

package com.rest.server.exception;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class DepartmentExcetionHandler  extends ResponseEntityExceptionHandler{


	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
   List<String> errs=  ex.getBindingResult().getFieldErrors().stream().map(x->x.getDefaultMessage()).collect(Collectors.toList());
            ErrorDetails errors = new ErrorDetails(new Date(), ex.getMessage(),request.getDescription(false), HttpStatus.NOT_FOUND.toString());
		
		
		
		return new ResponseEntity<Object>(errs, HttpStatus.BAD_REQUEST);
	
		//return new ResponseEntity<Object>(errors, status);
	}
	
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Object> handleContraintValidationExcetion(ConstraintViolationException ex, WebRequest req)
	{
ErrorDetails errors = new ErrorDetails(new Date(), ex.getMessage(),req.getDescription(false), HttpStatus.BAD_REQUEST.name());
		
		
		
		return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Object> handleResouseNotFoundException(ResourceNotFoundException ex, WebRequest req)
	{
		
		
	ErrorDetails errors = new ErrorDetails(new Date(), ex.getMessage(),req.getDescription(false), HttpStatus.NOT_FOUND.toString());
		
		
		
		return new ResponseEntity<Object>(errors, HttpStatus.NOT_FOUND);
	}
	
	

	@ExceptionHandler(BadResourceRequestException.class)
	public ResponseEntity<Object> handleBadResourceRequestException(BadResourceRequestException ex, WebRequest req){
		
ErrorDetails errors = new ErrorDetails(new Date(), ex.getMessage(),req.getDescription(false), HttpStatus.BAD_REQUEST.toString());
		
		
		
		return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
	}
	
	
	/*
	
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
   List<String> errs=  ex.getBindingResult().getFieldErrors().stream().map(x->x.getDefaultMessage()).collect(Collectors.toList());
           // ErrorDetails errors = new ErrorDetails(new Date(), message,request.getDescription(false), HttpStatus.NOT_FOUND.toString());
		
		
		
		return new ResponseEntity<Object>(errs, HttpStatus.BAD_REQUEST);
	//	return super.handleMethodArgumentNotValid(ex, headers, status, request);
	}


	
	
	*/
}

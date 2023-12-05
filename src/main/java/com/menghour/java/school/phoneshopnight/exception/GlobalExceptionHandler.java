package com.menghour.java.school.phoneshopnight.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*
 @ControllerAdvice is a specialization of the @Component annotation 
 which allows to handle exceptions across 
 the whole application in one global handling component
 */
@ControllerAdvice
public class GlobalExceptionHandler{
	@ExceptionHandler(ApiException.class)
	public ResponseEntity<?> handleApiException(ApiException e){
		// list all error Exception
//		return ResponseEntity
//				.status(e.getStatus())
//				.body(e);
//		get error Exception match errorResponse class
		 ErrorResponse errorResponse=new ErrorResponse(e.getStatus(),
		  e.getMessage());
		  return ResponseEntity
		  .status(e.getStatus())
		  .body(errorResponse);
	}
}

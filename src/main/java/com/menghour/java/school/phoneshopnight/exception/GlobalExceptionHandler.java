package com.menghour.java.school.phoneshopnight.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler{
	@ExceptionHandler(ApiException.class)
	public ResponseEntity<?> handleApiException(ApiException e){
		 ErrorResponse errorResponse=new ErrorResponse(e.getStatus(),
		  e.getMessage());
		  return ResponseEntity
		  .status(e.getStatus())
		  .body(errorResponse);
	}
	
/*
		@ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
	        Map<String, String> errors = new HashMap<>();
	        ex.getBindingResult().getAllErrors().forEach(error -> {
	            String fieldName = ((FieldError) error).getField();
	            String errorMessage = error.getDefaultMessage();
	            errors.put(fieldName, errorMessage);
	        });
	       
	        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	
	     //  ErrorResponse errorResponse=new ErrorResponse(HttpStatus.BAD_REQUEST,errors.toString());
         //  return ResponseEntity
         //  .status(HttpStatus.BAD_REQUEST)
         // 	.body(errorResponse);
	    }
    */
}

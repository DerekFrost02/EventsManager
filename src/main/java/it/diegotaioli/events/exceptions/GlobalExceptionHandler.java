package it.diegotaioli.events.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import it.diegotaioli.events.dto.ResponseErrorDto;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Object> handleResourceNotFound(ResourceNotFoundException ex) {
	    ResponseErrorDto responseErrorDto = new ResponseErrorDto<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
	    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseErrorDto);	
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<Object>handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex) {
		
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("status", HttpStatus.BAD_REQUEST);
		body.put("message", ex.getMessage());
		
		return new ResponseEntity<Object>(body,HttpStatus.BAD_REQUEST); 
	
	}
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<Object>handleBadRequestException(BadRequestException ex){
		Map<String, Object> body = new HashMap();
		body.put("status", HttpStatus.BAD_REQUEST);
		body.put("message", ex.getErrors());
		
		return new ResponseEntity<Object>(body,HttpStatus.BAD_REQUEST); 
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<Object>handleHttpMessageNotReadableException(HttpMessageNotReadableException ex){
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("status", HttpStatus.BAD_REQUEST);
		body.put("message", ex.getMessage());
		
		return new ResponseEntity<Object>(body,HttpStatus.BAD_REQUEST); 
	}
	

}

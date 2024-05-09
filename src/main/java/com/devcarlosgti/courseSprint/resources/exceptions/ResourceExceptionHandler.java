package com.devcarlosgti.courseSprint.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devcarlosgti.courseSprint.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice//a anotação @Component, que permite manipular exceções em todo o aplicativo em um componente global.
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)//estipula q um programa fará quando um evento anômo, interromper o fluxo normal das instruções desse programa.
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
		String error = "Resource not Found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
	    return ResponseEntity.status(status).body(err);
	}
}

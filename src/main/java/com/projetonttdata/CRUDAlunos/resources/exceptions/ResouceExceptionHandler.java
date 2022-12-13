package com.projetonttdata.CRUDAlunos.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.projetonttdata.CRUDAlunos.services.exceptions.ResourceNotFoundException;
  
@ControllerAdvice
class ResourceExceptionHandler extends RuntimeException {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException e, HttpServletRequest request){
		StandardError err = new StandardError();
		err.setTimestamp(Instant.now());
		err.setStatus(HttpStatus.NOT_FOUND.value());
		err.setError("Id do aluno não encontrado!");
		err.setPath(request.getRequestURI());
		return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}




}

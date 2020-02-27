package com.hcl.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class GlobalException extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ErrorMessageException.class)
	public ResponseEntity<ErrorMessageException> ErrorMessage(ErrorMessageException ex) {
		ErrorMessageException error = new ErrorMessageException(ex.getMessage());
		return new ResponseEntity<ErrorMessageException>(error, HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessageException> CommonErrorMessage(Exception ex) {
		ErrorMessageException error = new ErrorMessageException(ex.getMessage());
		return new ResponseEntity<ErrorMessageException>(error, HttpStatus.NOT_FOUND);

	}
}

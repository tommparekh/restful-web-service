package com.cognizant.course.springrest.restfulwebservice.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cognizant.course.springrest.restfulwebservice.user.UserNotFoundException;

@RestController
@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {

		ExceptionResponse exResp = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));

		return new ResponseEntity(exResp, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request) {

		ExceptionResponse exResp = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(true));

		return new ResponseEntity(exResp, HttpStatus.NOT_FOUND);

	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

<<<<<<< HEAD
		// ExceptionResponse exResp = new ExceptionResponse(new Date(), ex.getMessage(),
		// ex.getBindingResult().toString());

		ExceptionResponse exResp = new ExceptionResponse(new Date(), "Request Validation Failed",
				ex.getBindingResult().toString());
=======
	//	ExceptionResponse exResp = new ExceptionResponse(new Date(), ex.getMessage(), ex.getBindingResult().toString());

		ExceptionResponse exResp = new ExceptionResponse(new Date(), "Request Validation Failed", ex.getBindingResult().toString());
>>>>>>> refs/remotes/origin/master
		return new ResponseEntity(exResp, HttpStatus.BAD_REQUEST);
	}

}

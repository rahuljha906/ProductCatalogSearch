package com.developer.point.training.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author rahul
 *
 */
@ControllerAdvice
public class ProductCatalogExceptionController extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {

		
		ErrorResponse error = new ErrorResponse("Server Error","INTERNAL_SERVER_ERROR",500);
		return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ProductNotfoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(ProductNotfoundException ex, WebRequest request) {
		List<String> details = new ArrayList<>();
		
		ErrorResponse error = new ErrorResponse("Product Not Found","NOT_FOUND",404);
		return new ResponseEntity(error, HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> details = new ArrayList<>();
		for (ObjectError error : ex.getBindingResult().getAllErrors()) {
			details.add(error.getDefaultMessage());
		}
		ErrorResponse error = new ErrorResponse("Validation Failed", "BAD REQUEST",400);

		return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
	}

	
}

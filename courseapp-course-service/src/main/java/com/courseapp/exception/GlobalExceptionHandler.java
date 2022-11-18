package com.courseapp.exception;

import java.time.LocalDateTime;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.courseapp.model.ApiErrors;

/**
 * @author JagannathSutar
 * This exception class determine the project's behavior when encountering an execution error
 *	Extend from ResponseEntityExceptionHandler
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	/**
	 *	when request method not supported this exception handler will called 
	 */
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message=ex.getMessage();
		String error="Request Mathod not supported";
		ApiErrors errors=new ApiErrors(LocalDateTime.now(), message,status,status.value(),error);
		headers.add("info", message);
		return ResponseEntity.status(status).headers(headers).body(errors);
	}

	/**
	 *	when media type not supported this exception handler called 
	 */
	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message=ex.getMessage();
		String error="Media type not supported";
		ApiErrors errors=new ApiErrors(LocalDateTime.now(), message,status,status.value(),error);
		headers.add("info", message);
		return ResponseEntity.status(status).headers(headers).body(errors);
	}

	/**
	 *	When path variable missing this exception handler called
	 */
	
	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String message=ex.getMessage();
		String error="Missing path variable";
		ApiErrors errors=new ApiErrors(LocalDateTime.now(), message,status,status.value(),error);
		headers.add("info", message);
		return ResponseEntity.status(status).headers(headers).body(errors);
	}

	/**
	 *	When request parameter missing this exception handler called
	 */
	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message=ex.getMessage();
		String error="Request parameter missing";
		ApiErrors errors=new ApiErrors(LocalDateTime.now(), message,status,status.value(),error);
		headers.add("info", message);
		return ResponseEntity.status(status).headers(headers).body(errors);
	}

	/**
	 *	When input type not match as expected this exception handler called
	 */
	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String message=ex.getMessage();
		String error="Type missmath ";
		ApiErrors errors=new ApiErrors(LocalDateTime.now(), message,status,status.value(),error);
		
		headers.add("info", message);
		return ResponseEntity.status(status).headers(headers).body(errors);
	}
	
	/**
	 * @param ex
	 * @return status of response entity
	 * When course is empty this exception handler called
	 */
	@ExceptionHandler(CourseNotFoundException.class)
	public ResponseEntity<Object> handleCourseNotFound(CourseNotFoundException ex){
		String message=ex.getMessage();
		String error="Course Not found exception";
		ApiErrors errors=new ApiErrors(LocalDateTime.now(), message,HttpStatus.CONFLICT,HttpStatus.CONFLICT.value(),error);;
		HttpHeaders headers=new HttpHeaders();
		headers.add("info", message);
		return ResponseEntity.status(HttpStatus.CONFLICT).headers(headers).body(errors);
	}
	
	/**
	 * @param ex
	 * @return status of response entity
	 * When student is empty this exception handler called
	 */
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<Object> handleStudentNotFound(StudentNotFoundException ex){
		String message=ex.getMessage();
		String error="Student Not found exception";
		ApiErrors errors=new ApiErrors(LocalDateTime.now(), message,HttpStatus.CONFLICT,HttpStatus.CONFLICT.value(),error);;
		HttpHeaders headers=new HttpHeaders();
		headers.add("info", message);
		return ResponseEntity.status(HttpStatus.CONFLICT).headers(headers).body(errors);
	}
	
	
	/**
	 * @param ex
	 * @return status of response entity
	 * When Id of any entity not found this exception handler called
	 */
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<Object> handleIdNotFoundException(IdNotFoundException ex){
		
		String message=ex.getMessage();
		String error="Id Not found exception";
		ApiErrors errors=new ApiErrors(LocalDateTime.now(), message,HttpStatus.CONFLICT,HttpStatus.CONFLICT.value(),error);;
		HttpHeaders headers=new HttpHeaders();
		headers.add("info", message);
		return ResponseEntity.status(HttpStatus.CONFLICT).headers(headers).body(errors);
		
	}
	
	
	
}

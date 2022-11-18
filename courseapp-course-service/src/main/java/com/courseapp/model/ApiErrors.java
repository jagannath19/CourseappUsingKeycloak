package com.courseapp.model;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

/**
 * @author JagannathSutar
 *	This need when the request has failed, and the action is not completed
 */
public class ApiErrors {
	
	LocalDateTime timestamp;
	String message;
	HttpStatus status;
	int statusCode;
	String error;
	public ApiErrors(LocalDateTime timestamp, String message, HttpStatus status, int statusCode, String error) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.status = status;
		this.statusCode = statusCode;
		this.error = error;
	}
	/**
	 * @return the timestamp
	 */
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the status
	 */
	public HttpStatus getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	/**
	 * @return the statusCode
	 */
	public int getStatusCode() {
		return statusCode;
	}
	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}
	/**
	 * @param error the error to set
	 */
	public void setError(String error) {
		this.error = error;
	}
	
	
	@Override
	public String toString() {
		return "ApiErrors [timestamp=" + timestamp + ", message=" + message + ", status=" + status + ", statusCode="
				+ statusCode + ", error=" + error + "]";
	}
	
	

}

/**
 * 
 */
package com.courseapp.exception;

/**
 * @author JagannathSutar
 * Custom exception class extends from RunntimeException
 */
public class StudentNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StudentNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	

}

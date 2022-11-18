/**
 * 
 */
package com.courseapp.exception;

/**
 * @author JagannathSutar
 *	Custom exception class extends from RunntimeException
 */
public class CourseNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CourseNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CourseNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	

}

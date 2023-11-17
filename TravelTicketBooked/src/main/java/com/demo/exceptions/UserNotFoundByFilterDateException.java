package com.demo.exceptions;

public class UserNotFoundByFilterDateException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFoundByFilterDateException(String filterDate) {
        super("No users found for the filter date: " + filterDate);
    }
}
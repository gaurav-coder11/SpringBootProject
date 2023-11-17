package com.demo.exceptions;

public class UserNotFoundByIdException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFoundByIdException(Long userId) {
        super("User not found with ID: " + userId);
    }
}

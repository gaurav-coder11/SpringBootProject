package com.demo.exceptions;

public class UserUpdateException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserUpdateException(Long userId) {
        super("Unable to update user with ID: " + userId + ". User not found.");
    }
}
